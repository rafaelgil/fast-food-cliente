package br.com.fiap.postech.fastfood.adapter.presenter

import br.com.fiap.postech.fastfood.adapter.gateway.schema.CheckoutSchema
import br.com.fiap.postech.fastfood.domain.entity.Checkout
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime
import java.util.*


data class CheckoutResponse(
    var id: UUID? = null,
    @JsonProperty("id_pedido")
    var pedidoId: UUID,
    var pagamento: PagamentoResponse,
    var data: LocalDateTime
)

fun Checkout.toCheckoutSchema() =
    CheckoutSchema(
        pedido = this.pedido.toPedidoSchema(),
        pagamento = this.pagamento.toPagamentoSchema(),
        data = this.data
    )


fun CheckoutSchema.toCheckout() =
    Checkout (
        id = this.id,
        pedido = this.pedido.toPedido(),
        pagamento = this.pagamento.toPagamento(),
        data = this.data
    )

fun Checkout.toResponse() =
    CheckoutResponse(
        id = this.id,
        pedidoId = this.pedido.id!!,
        pagamento = this.pagamento.toResponse(),
        data = this.data
    )
