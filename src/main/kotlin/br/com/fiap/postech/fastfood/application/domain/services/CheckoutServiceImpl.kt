package br.com.fiap.postech.fastfood.application.domain.services

import br.com.fiap.postech.fastfood.application.domain.dtos.CheckoutDTO
import br.com.fiap.postech.fastfood.application.domain.exception.NotFoundEntityException
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

    override fun enviaParaFila(checkout: CheckoutDTO) {

        if (checkout.pedido?.id == null) {
            throw IllegalArgumentException("Pedido inválido!")
        }

        var pedido = pedidoRepositoryPort.busca(checkout.pedido.id!!)

        if (pedido.isEmpty) {
            throw NotFoundEntityException("Pedido não encontrado!")
        }

        this.checkoutRepositoryPort.enviaCheckout(checkout.toCheckoutModel(pedido.get().toPedidoModel()))
    }
}