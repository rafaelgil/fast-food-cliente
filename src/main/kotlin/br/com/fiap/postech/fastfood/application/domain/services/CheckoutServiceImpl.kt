package br.com.fiap.postech.fastfood.application.domain.services

import br.com.fiap.postech.fastfood.application.domain.dtos.CheckoutDTO
import br.com.fiap.postech.fastfood.application.domain.dtos.CheckoutRequest
import br.com.fiap.postech.fastfood.application.domain.exception.NotFoundEntityException
import br.com.fiap.postech.fastfood.application.domain.extension.toCheckoutDTO
import br.com.fiap.postech.fastfood.application.domain.extension.toCheckoutModel
import br.com.fiap.postech.fastfood.application.domain.extension.toPedidoModel
import br.com.fiap.postech.fastfood.application.ports.interfaces.CheckoutServicePort
import br.com.fiap.postech.fastfood.application.ports.repositories.CheckoutRepositoryPort
import br.com.fiap.postech.fastfood.application.ports.repositories.PedidoRepositoryPort
import java.util.*

class CheckoutServiceImpl(
    private val checkoutRepositoryPort: CheckoutRepositoryPort,
    private val pedidoRepositoryPort: PedidoRepositoryPort
): CheckoutServicePort {

    override fun enviaParaFila(checkoutRequest: CheckoutRequest): CheckoutDTO {

        var checkoutDto = checkoutRequest.toCheckoutDTO()

        if (checkoutDto.idPedido == null) {
            throw IllegalArgumentException("Pedido inválido!")
        }

        var pedido = pedidoRepositoryPort.busca(checkoutDto.idPedido!!)

        if (pedido.isEmpty) {
            throw NotFoundEntityException("Pedido não encontrado!")
        }

//        if (this.checkoutRepositoryPort.existeCheckoutComPedido(pedido.id)) {
//
//        }

        var checkoutSended = this.checkoutRepositoryPort.enviaCheckout(checkoutDto.toCheckoutModel(pedido.get().toPedidoModel()))
        return checkoutSended.toCheckoutDTO()
    }
}