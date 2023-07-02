package br.com.fiap.postech.fastfood.adapter.inbound.extension

import br.com.fiap.postech.fastfood.adapter.inbound.request.CheckoutRequest
import br.com.fiap.postech.fastfood.adapter.inbound.response.CheckoutResponse
import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.CheckoutEntity
import br.com.fiap.postech.fastfood.application.domain.dtos.CheckoutDTO
import br.com.fiap.postech.fastfood.application.domain.dtos.PedidoDTO
import br.com.fiap.postech.fastfood.application.domain.extension.toPagamentoEntity
import br.com.fiap.postech.fastfood.application.domain.models.Checkout
import br.com.fiap.postech.fastfood.application.domain.valueObjets.StatusCheckout
import java.time.LocalDateTime

fun CheckoutRequest.toCheckoutDTO(): CheckoutDTO {
    return CheckoutDTO(
        pedido = PedidoDTO(id = this.idPedido, data = null, status = null, acompanhamento = null, bebida = null, cliente = null, lanche = null, sobremesa = null, clienteId = null, lancheId = null, bebidaId = null, acompanhamentoId = null, sobremesaId = null),
        status = StatusCheckout.ENVIADO.name,
        data = LocalDateTime.now()
    )
}

fun CheckoutDTO.toCheckoutResponse(): CheckoutResponse {
    return CheckoutResponse(
        id = this.id,
        pedidoId = this.pedido?.id,
        pagamentoId = this.pagamento?.id,
        status = this.status,
        data = this.data
    )
}

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