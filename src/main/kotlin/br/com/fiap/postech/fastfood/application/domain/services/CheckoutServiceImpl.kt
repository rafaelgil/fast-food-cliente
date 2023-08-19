package br.com.fiap.postech.fastfood.application.domain.services

import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.extension.toCheckoutDTO
import br.com.fiap.postech.fastfood.application.domain.dtos.CheckoutDTO
import br.com.fiap.postech.fastfood.application.domain.dtos.PagamentoDTO
import br.com.fiap.postech.fastfood.application.domain.exception.NotFoundEntityException
import br.com.fiap.postech.fastfood.application.domain.extension.toCheckoutModel
import br.com.fiap.postech.fastfood.application.domain.extension.toPedidoDTO
import br.com.fiap.postech.fastfood.domain.entity.Checkout
import br.com.fiap.postech.fastfood.domain.entity.Pagamento
import br.com.fiap.postech.fastfood.domain.entity.Pedido
import br.com.fiap.postech.fastfood.domain.valueObjets.FormaPagamento
import br.com.fiap.postech.fastfood.domain.valueObjets.StatusCheckout
import br.com.fiap.postech.fastfood.domain.valueObjets.StatusPagamento
import br.com.fiap.postech.fastfood.application.ports.interfaces.CheckoutServicePort
import br.com.fiap.postech.fastfood.application.ports.interfaces.PagamentoServicePort
import br.com.fiap.postech.fastfood.application.ports.repositories.CheckoutRepositoryPort
import br.com.fiap.postech.fastfood.application.ports.repositories.PedidoRepositoryPort
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

class CheckoutServiceImpl(
    private val checkoutRepositoryPort: CheckoutRepositoryPort,
    private val pedidoRepositoryPort: PedidoRepositoryPort,
    private val pagamentoServicePort: PagamentoServicePort
): CheckoutServicePort {

    override fun enviaParaFila(checkoutDto: CheckoutDTO): CheckoutDTO {

        if (checkoutDto.pedido?.id == null) {
            throw IllegalArgumentException("Pedido inválido!")
        }

        var pedido = this.buscaPedido(checkoutDto.pedido!!.id!!)
        var checkoutFound = this.checkoutRepositoryPort.buscaCheckoutPeloPedido(pedido)
        var checkout: Checkout?

        if (checkoutFound.isPresent) {
            checkout = checkoutFound.get()
            checkout.status = StatusCheckout.REENVIADO
            checkout.data = LocalDateTime.now()
        } else {
            var valor = this.calculaValor(pedido)
            var pagamentoDTO = PagamentoDTO(
                formaPagamento = FormaPagamento.QR_CODE.name,
                valor = valor
            )

            var pagamentoResult = efetuaPagamento(pagamentoDTO)
            checkoutDto.pedido = pedido.toPedidoDTO()

            checkout = checkoutDto.toCheckoutModel()
            checkout.pagamento = pagamentoResult
        }
        return this.enviaCheckout(checkout)
    }

    private fun buscaPedido(idPedido: UUID): Pedido {
        var pedidoFound = this.pedidoRepositoryPort.busca(idPedido)
        if (pedidoFound.isPresent) {
            return  pedidoFound.get()
        } else {
            throw NotFoundEntityException("Pedido não encontrado!")
        }
    }

    private fun calculaValor(pedidoFound: Pedido): BigDecimal {
        var valor: BigDecimal = BigDecimal.ZERO

        /*
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
        */

        return valor
    }

    private fun efetuaPagamento(pagamentoDTO: PagamentoDTO): Pagamento {
        var pagamentoResult = this.pagamentoServicePort.efetuaPagamento(pagamentoDTO)
        validaPagamento(pagamentoResult)
        return pagamentoResult
    }

    private fun validaPagamento(pagamento: Pagamento) {
        if (pagamento == null || pagamento.id == null) {
            throw IllegalArgumentException("Pagamento inválido.")
        }

        if (pagamento.status == null) {
            throw IllegalArgumentException("Pagamento com status inválido.")
        }

        if (!StatusPagamento.APROVADO.equals(pagamento.status)) {
            throw IllegalArgumentException("Pagamento Não aprovado")
        }
    }

    private fun enviaCheckout(checkout: Checkout): CheckoutDTO {
        return this.checkoutRepositoryPort.enviaCheckout(checkout)
            .toCheckoutDTO()
    }
}