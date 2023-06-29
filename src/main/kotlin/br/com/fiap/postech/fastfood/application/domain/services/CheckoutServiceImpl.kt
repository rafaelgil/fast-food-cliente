package br.com.fiap.postech.fastfood.application.domain.services

import br.com.fiap.postech.fastfood.application.domain.dtos.CheckoutDTO
import br.com.fiap.postech.fastfood.application.domain.dtos.CheckoutRequestDTO
import br.com.fiap.postech.fastfood.application.domain.exception.AlreadyProcessedException
import br.com.fiap.postech.fastfood.application.domain.exception.NotFoundEntityException
import br.com.fiap.postech.fastfood.application.domain.extension.*
import br.com.fiap.postech.fastfood.application.domain.models.Checkout
import br.com.fiap.postech.fastfood.application.domain.valueObjets.StatusCheckout
import br.com.fiap.postech.fastfood.application.ports.interfaces.CheckoutServicePort
import br.com.fiap.postech.fastfood.application.ports.repositories.CheckoutRepositoryPort
import br.com.fiap.postech.fastfood.application.ports.repositories.PedidoRepositoryPort
import java.time.LocalDateTime

class CheckoutServiceImpl(
    private val checkoutRepositoryPort: CheckoutRepositoryPort,
    private val pedidoRepositoryPort: PedidoRepositoryPort
): CheckoutServicePort {

    override fun enviaParaFila(checkoutRequest: CheckoutRequestDTO): CheckoutDTO {

        var checkoutDto = checkoutRequest.toCheckoutDTO()

        if (checkoutDto.idPedido == null) {
            throw IllegalArgumentException("Pedido inválido!")
        }

        var pedido = pedidoRepositoryPort.busca(checkoutDto.idPedido!!)

        if (pedido.isEmpty) {
            throw NotFoundEntityException("Pedido não encontrado!")
        }

        var pedidoFound = pedido.get()

        var checkoutFound = this.checkoutRepositoryPort.buscaCheckoutPeloPedido(pedidoFound.toPedidoEntity())
        if (checkoutFound.isPresent) {

            var checkout = checkoutFound.get().toCheckoutModel()
            validaCheckoutEncontrado(checkout)

            checkout.status = StatusCheckout.PAGAMENTO_APROVADO
            checkout.data = LocalDateTime.now()
            checkoutDto = checkout.toCheckoutDTO()
        }
        checkoutDto.status = StatusCheckout.PAGAMENTO_APROVADO
        return this.enviaCheckout(checkoutDto)
    }

    private fun enviaCheckout(checkoutDTO: CheckoutDTO): CheckoutDTO {
        return this.checkoutRepositoryPort.enviaCheckout(checkoutDTO.toCheckoutModel())
            .toCheckoutDTO()
    }

    private fun validaCheckoutEncontrado(checkout: Checkout) {
        if(checkout.estaProcessado()) {
            throw AlreadyProcessedException("Pagamento já efetuado")
        }
    }
}