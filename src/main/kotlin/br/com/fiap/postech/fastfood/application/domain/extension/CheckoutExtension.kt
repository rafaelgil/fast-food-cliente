package br.com.fiap.postech.fastfood.application.domain.extension

import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.CheckoutEntity
import br.com.fiap.postech.fastfood.application.domain.dtos.CheckoutDTO
import br.com.fiap.postech.fastfood.application.domain.models.Checkout
import br.com.fiap.postech.fastfood.application.domain.models.Pedido
import br.com.fiap.postech.fastfood.application.domain.valueObjets.FormaPagamento
import br.com.fiap.postech.fastfood.application.domain.valueObjets.StatusCheckout

fun CheckoutDTO.toCheckoutModel(): Checkout {
    return Checkout(
        id = this.id,
        pedido = Pedido(id = this.pedido!!.id),
        status = this.status?.let { StatusCheckout.valueOf(it) },
//        formaPagamento = FormaPagamento.QR_CODE,
        data = this.data
    )
}

fun Checkout.toCheckoutDTO(): CheckoutDTO {
    return CheckoutDTO (
        id = this.id,
        pedido  = this.pedido?.toPedidoDTO(),
        status = this.status?.name,
//        formaPagamento = this.formaPagamento,
        data = this.data
    )
}

fun Checkout.toCheckoutEntity(): CheckoutEntity {
    return CheckoutEntity(
        id = this.id,
        pedido = this.pedido?.toPedidoEntity(),
        status = this.status,
//        formaPagamento = this.formaPagamento,
        dataCheckout = this.data
    )
}

fun CheckoutEntity.toCheckoutDTO(): CheckoutDTO {
    return CheckoutDTO(
        id = this.id,
        pedido = this.pedido?.toPedidoDTO(),
        status = this.status?.name,
//        formaPagamento = this.formaPagamento,
        data = this.dataCheckout
    )
}

fun CheckoutEntity.toCheckoutModel(): Checkout {
    return Checkout(
        id = this.id,
        pedido = this.pedido?.toPedidoModel(),
        status = this.status,
//        formaPagamento = this.formaPagamento,
        data = this.dataCheckout
    )
}



fun Checkout.estaProcessado(): Boolean {
    return true// StatusCheckout.PAGAMENTO_APROVADO.equals(this.status)
}
