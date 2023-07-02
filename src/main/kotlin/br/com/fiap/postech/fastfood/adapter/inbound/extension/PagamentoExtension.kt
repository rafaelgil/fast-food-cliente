package br.com.fiap.postech.fastfood.adapter.inbound.extension

import br.com.fiap.postech.fastfood.adapter.inbound.request.PagamentoRequest
import br.com.fiap.postech.fastfood.adapter.inbound.response.PagamentoResponse
import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.PagamentoEntity
import br.com.fiap.postech.fastfood.application.domain.dtos.PagamentoDTO
import br.com.fiap.postech.fastfood.application.domain.models.Pagamento
import br.com.fiap.postech.fastfood.application.domain.valueObjets.FormaPagamento
import br.com.fiap.postech.fastfood.application.domain.valueObjets.StatusPagamento

fun PagamentoEntity.toPagamentoDTO(): PagamentoDTO {
    return PagamentoDTO(
        id = this.id,
        formaPagamento = this.formaPagamento,
        valor = this.valor,
        status = this.status
    )
}

fun PagamentoRequest.toPagamentoDTO(): PagamentoDTO {
    return PagamentoDTO(
        formaPagamento = this.formaPagamento,
        valor = this.valor
    )
}

fun PagamentoDTO.toPagamentoResponse(): PagamentoResponse {
    return PagamentoResponse(
        id = this.id,
        status = this.status
    )
}

fun PagamentoEntity.toPagamentoModel(): Pagamento {
    return Pagamento(
        id = this.id,
        valor = this.valor,
        formaPagamento = this.formaPagamento?.let { FormaPagamento.valueOf(it) },
        status = this.status?.let { StatusPagamento.valueOf(it) }
    )
}