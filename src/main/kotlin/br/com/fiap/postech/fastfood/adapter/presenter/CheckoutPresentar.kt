package br.com.fiap.postech.fastfood.adapter.presenter

import br.com.fiap.postech.fastfood.adapter.gateway.schema.CheckoutSchema
import br.com.fiap.postech.fastfood.domain.entity.Checkout
import java.time.LocalDateTime
import java.util.*


data class CheckoutResponse(
    var id: UUID? = null,
    var pedido: PedidoResponse,
    var data: LocalDateTime
)

fun Checkout.toCheckoutSchema() =
    CheckoutSchema(
        pedido = this.pedido.toPedidoSchema(),
        data = this.data
    )


fun CheckoutSchema.toCheckout() =
    Checkout (
        id = this.id,
        pedido = this.pedido.toPedido(),
        data = this.data
    )

fun Checkout.toResponse() =
    CheckoutResponse(
        id = this.id,
        pedido = this.pedido.toResponse(),
        data = this.data
    )
