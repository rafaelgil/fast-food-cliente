package br.com.fiap.postech.fastfood.application.domain.extension

import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.CheckoutEntity
import br.com.fiap.postech.fastfood.application.domain.dtos.CheckoutDTO
import br.com.fiap.postech.fastfood.application.domain.dtos.CheckoutRequest
import br.com.fiap.postech.fastfood.application.domain.dtos.PedidoDTO
import br.com.fiap.postech.fastfood.application.domain.models.Checkout
import br.com.fiap.postech.fastfood.application.domain.models.Pedido
import br.com.fiap.postech.fastfood.application.domain.valueObjets.StatusCheckout
import java.time.LocalDateTime

fun CheckoutDTO.toCheckoutModel(pedido: Pedido): Checkout {
    return Checkout(
        id = this.id,
        pedido = pedido,
        status = this.status,
        data = this.data
    )
}

fun Checkout.toCheckoutEntity(): CheckoutEntity {
    return CheckoutEntity(
        id = this.id,
        pedido = this.pedido.toPedidoEntity(),
        status = this.status.status,
        dataCheckout = this.data
    )
}

fun CheckoutEntity.toCheckoutDTO(): CheckoutDTO {
    return CheckoutDTO(
        id = this.id,
        idPedido = this.pedido.id,
        status = StatusCheckout.valueOf(this.status.uppercase()),
        data = this.dataCheckout
    )
}

fun CheckoutRequest.toCheckoutDTO(): CheckoutDTO {
    return CheckoutDTO(
        idPedido = this.idPedido,
        status = StatusCheckout.ENVIADO,
        data = LocalDateTime.now()
    )
}
