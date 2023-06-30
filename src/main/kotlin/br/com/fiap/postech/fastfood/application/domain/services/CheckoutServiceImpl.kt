package br.com.fiap.postech.fastfood.application.domain.services

import br.com.fiap.postech.fastfood.application.domain.dtos.CheckoutDTO
import br.com.fiap.postech.fastfood.application.domain.dtos.PagamentoDTO
import br.com.fiap.postech.fastfood.application.domain.exception.AlreadyProcessedException
import br.com.fiap.postech.fastfood.application.domain.exception.NotFoundEntityException
import br.com.fiap.postech.fastfood.application.domain.extension.estaProcessado
import br.com.fiap.postech.fastfood.application.domain.extension.toCheckoutDTO
import br.com.fiap.postech.fastfood.application.domain.extension.toCheckoutModel
import br.com.fiap.postech.fastfood.application.domain.extension.toPagamentoModel
import br.com.fiap.postech.fastfood.application.domain.models.Checkout
import br.com.fiap.postech.fastfood.application.domain.models.Pedido
import br.com.fiap.postech.fastfood.application.domain.valueObjets.FormaPagamento
import br.com.fiap.postech.fastfood.application.domain.valueObjets.StatusCheckout
import br.com.fiap.postech.fastfood.application.ports.interfaces.CheckoutServicePort
import br.com.fiap.postech.fastfood.application.ports.interfaces.PagamentoServicePort
import br.com.fiap.postech.fastfood.application.ports.repositories.CheckoutRepositoryPort
import br.com.fiap.postech.fastfood.application.ports.repositories.PedidoRepositoryPort
import java.math.BigDecimal
import java.time.LocalDateTime

class CheckoutServiceImpl(
    private val checkoutRepositoryPort: CheckoutRepositoryPort,
    private val pedidoRepositoryPort: PedidoRepositoryPort,
    private val pagamentoServicePort: PagamentoServicePort
): CheckoutServicePort {

    override fun enviaParaFila(checkoutDto: CheckoutDTO): CheckoutDTO {

        if (checkoutDto.pedido?.id == null) {
            throw IllegalArgumentException("Pedido inválido!")
        }

        var pedido = pedidoRepositoryPort.busca(checkoutDto.pedido!!.id!!)

        if (pedido.isEmpty) {
            throw NotFoundEntityException("Pedido não encontrado!")
        }

        var pedidoFound = pedido.get()

        var checkoutFound = this.checkoutRepositoryPort.buscaCheckoutPeloPedido(pedido.get())
        var checkout: Checkout? = null

        if (checkoutFound.isPresent) {
            checkout = checkoutFound.get()
//            validaCheckoutEncontrado(checkout)
            checkout.status = StatusCheckout.REENVIADO
            checkout.data = LocalDateTime.now()
        } else {
            var valor = calculaValor(pedidoFound)
            var pagamentoDTO = PagamentoDTO(
                formaPagamento = FormaPagamento.QR_CODE.name,
                valor = valor
            )

            var pagamentoResult = pagamentoServicePort.efetuaPagamento(pagamentoDTO)

            checkout = checkoutDto.toCheckoutModel()
            checkout.pagamento = pagamentoResult.toPagamentoModel()
        }
        return this.enviaCheckout(checkout)
    }

    private fun calculaValor(pedidoFound: Pedido): BigDecimal {
        var valor: BigDecimal = BigDecimal.ZERO

        if (pedidoFound.bebida != null) {
            valor = valor.add(pedidoFound.bebida!!.preco.valor)
        }

        if (pedidoFound?.lanche?.preco != null) {
            valor = valor.add(pedidoFound?.lanche!!.preco.valor)
        }

        if (pedidoFound?.acompanhamento?.preco != null) {
            valor = valor.add(pedidoFound?.acompanhamento!!.preco.valor)
        }

        if (pedidoFound?.sobremesa?.preco != null) {
            valor = valor.add(pedidoFound?.sobremesa!!.preco.valor)
        }


        return valor
    }

    private fun enviaCheckout(checkout: Checkout): CheckoutDTO {
        return this.checkoutRepositoryPort.enviaCheckout(checkout)
            .toCheckoutDTO()
    }

    private fun validaCheckoutEncontrado(checkout: Checkout) {
        if(checkout.estaProcessado()) {
            throw AlreadyProcessedException("Pagamento já efetuado")
        }
    }
}