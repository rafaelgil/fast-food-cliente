package br.com.fiap.postech.fastfood.application.domain.extension

import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.CheckoutEntity
import br.com.fiap.postech.fastfood.application.domain.dtos.CheckoutDTO
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
        pedido = PedidoDTO(
            id = this.pedido.id,
            clienteId = this.pedido.clienteId,
            lancheId = this.pedido.lancheId,
            bebidaId = this.pedido.bebidaId,
            sobremesaId = this.pedido.sobremesaId,
            acompanhamentoId = this.pedido.acompanhamentoId,
            status = this.pedido.status,
            dataPedido = this.pedido.dataPedido
        ),
        status = StatusCheckout.valueOf(this.status.uppercase())
    )
}

