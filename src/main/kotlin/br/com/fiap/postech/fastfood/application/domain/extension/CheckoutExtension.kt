package br.com.fiap.postech.fastfood.application.domain.extension

import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.CheckoutEntity
import br.com.fiap.postech.fastfood.application.domain.dtos.CheckoutDTO
import br.com.fiap.postech.fastfood.application.domain.dtos.CheckoutRequest
import br.com.fiap.postech.fastfood.application.domain.dtos.PedidoDTO
import br.com.fiap.postech.fastfood.application.domain.models.Checkout
import br.com.fiap.postech.fastfood.application.domain.models.Pedido
import br.com.fiap.postech.fastfood.application.domain.valueObjets.StatusCheckout

fun CheckoutDTO.toCheckoutModel(pedido: Pedido): Checkout {
    return Checkout(
        id = this.id,
        pedido = pedido,
        status = this.status
    )
}

fun Checkout.toCheckoutEntity(): CheckoutEntity {
    return CheckoutEntity(
        pedido = this.pedido.toPedidoEntity(),
        status = this.status.status
    )
}

fun CheckoutEntity.toCheckoutDTO(): CheckoutDTO {
    return CheckoutDTO(
        id = this.id,
        idPedido = this.pedido.id,
        status = StatusCheckout.valueOf(this.status.uppercase())
    )
}

fun CheckoutRequest.toCheckoutDTO(): CheckoutDTO {
    return CheckoutDTO(
        idPedido = this.idPedido,
        status = StatusCheckout.ENVIADO
    )
}
