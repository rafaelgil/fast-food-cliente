package br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.extension

import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.CheckoutEntity
import br.com.fiap.postech.fastfood.application.domain.dtos.CheckoutDTO
import br.com.fiap.postech.fastfood.domain.entity.Checkout

fun Checkout.toCheckoutEntity(): CheckoutEntity {
    return CheckoutEntity(
        id = this.id,
        pedido = this.pedido?.toPedidoEntity(),
        status = this.status,
        pagamento = this.pagamento?.toPagamentoEntity(),
        dataCheckout = this.data
    )
}

fun CheckoutEntity.toCheckoutDTO(): CheckoutDTO {
    return CheckoutDTO(
        id = this.id,
        pedido = this.pedido?.toPedidoDTO(),
        status = this.status?.name,
        pagamento = this.pagamento?.toPagamentoDTO(),
        data = this.dataCheckout
    )
}

fun CheckoutEntity.toCheckoutModel(): Checkout {
    return Checkout(
        id = this.id,
        pedido = this.pedido?.toPedidoModel(),
        status = this.status,
        pagamento = this.pagamento?.toPagamentoModel(),
        data = this.dataCheckout
    )
}