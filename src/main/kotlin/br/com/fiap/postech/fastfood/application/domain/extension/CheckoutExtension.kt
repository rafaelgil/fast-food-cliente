package br.com.fiap.postech.fastfood.application.domain.extension

import br.com.fiap.postech.fastfood.application.domain.dtos.CheckoutDTO
import br.com.fiap.postech.fastfood.application.domain.models.Checkout

fun CheckoutDTO.toCheckout(): Checkout {
    return Checkout(
        id = this.id,
        pedido = this.pedido.toPedidoModel(),
        status = this.status
    )
}

