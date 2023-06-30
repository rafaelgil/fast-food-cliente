package br.com.fiap.postech.fastfood.application.domain.extension

import br.com.fiap.postech.fastfood.adapter.inbound.extension.toPagamentoDTO
import br.com.fiap.postech.fastfood.adapter.inbound.extension.toPagamentoModel
import br.com.fiap.postech.fastfood.adapter.inbound.request.CheckoutRequest
import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.CheckoutEntity
import br.com.fiap.postech.fastfood.application.domain.dtos.CheckoutDTO
import br.com.fiap.postech.fastfood.application.domain.dtos.PedidoDTO
import br.com.fiap.postech.fastfood.application.domain.models.Checkout
import br.com.fiap.postech.fastfood.application.domain.models.Pedido
import br.com.fiap.postech.fastfood.application.domain.valueObjets.FormaPagamento
import br.com.fiap.postech.fastfood.application.domain.valueObjets.StatusCheckout
import java.time.LocalDateTime

fun CheckoutDTO.toCheckoutModel(): Checkout {
    return Checkout(
        id = this.id,
        pedido = this.pedido?.toPedidoModel(),
        status = this.status?.let { StatusCheckout.valueOf(it) },
        pagamento = this.pagamento?.toPagamentoModel(),
        data = this.data
    )
}

fun Checkout.toCheckoutDTO(): CheckoutDTO {
    return CheckoutDTO (
        id = this.id,
        pedido = this.pedido?.toPedidoDTO(),
        status = this.status?.name,
        pagamento = this.pagamento?.toPagamentoDTO(),
        data = this.data
    )
}


