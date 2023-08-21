package br.com.fiap.postech.fastfood.application.domain.extension

import br.com.fiap.postech.fastfood.application.domain.dtos.CheckoutDTO
import br.com.fiap.postech.fastfood.domain.entity.Checkout
import br.com.fiap.postech.fastfood.domain.valueObjets.StatusCheckout

fun CheckoutDTO.toCheckoutModel(): Checkout {
    return Checkout(
        id = this.id,
        pedido = this.pedido!!.toPedidoModel(this.pedido!!.id),
        //status = this.status?.let { StatusCheckout.valueOf(it) },
        pagamento = this.pagamento!!.toPagamentoModel(),
        data = this.data!!
    )
}

fun Checkout.toCheckoutDTO(): CheckoutDTO {
    return CheckoutDTO (
        id = this.id,
        pedido = this.pedido!!.toPedidoDTO(),
        //status = this.status,
        pagamento = this.pagamento!!.toPagamentoDTO(),
        data = this.data
    )
}


