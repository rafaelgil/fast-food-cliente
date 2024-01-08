package br.com.fiap.postech.fastfood.adapter.presenter

import br.com.fiap.postech.fastfood.adapter.gateway.schema.PagamentoSchema
import br.com.fiap.postech.fastfood.domain.entity.Pagamento
import java.util.*

data class PagamentoResponse(
    var id: UUID,
    var status: String
)

fun Pagamento.toPagamentoSchema() =
    PagamentoSchema(
        id = this.id,
        status = status
    )

fun PagamentoSchema.toPagamento() =
    Pagamento(
        id = this.id,
        status = this.status
    )

fun Pagamento.toResponse() =
    PagamentoResponse(
        id = this.id,
        status = this.status.name,
    )