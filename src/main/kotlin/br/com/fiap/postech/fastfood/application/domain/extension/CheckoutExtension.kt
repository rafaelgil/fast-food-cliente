package br.com.fiap.postech.fastfood.application.domain.extension

import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.CheckoutEntity
import br.com.fiap.postech.fastfood.application.domain.dtos.CheckoutDTO
import br.com.fiap.postech.fastfood.application.domain.models.Checkout

fun CheckoutDTO.toCheckout(): Checkout {
    return Checkout(
        id = this.id,
        pedido = this.pedido.toPedidoModel(),
        status = this.status
    )
}

fun Checkout.toCheckoutEntity(): CheckoutEntity {
    return CheckoutEntity(
        pedido = this.pedido.toPedidoEntity(),
        status = this.status.status
    )
}

