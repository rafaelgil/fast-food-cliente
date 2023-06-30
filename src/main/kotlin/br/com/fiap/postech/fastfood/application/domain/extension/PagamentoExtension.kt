package br.com.fiap.postech.fastfood.application.domain.extension

import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.PagamentoEntity
import br.com.fiap.postech.fastfood.application.domain.dtos.PagamentoDTO
import br.com.fiap.postech.fastfood.application.domain.models.Pagamento
import br.com.fiap.postech.fastfood.application.domain.valueObjets.FormaPagamento
import br.com.fiap.postech.fastfood.application.domain.valueObjets.StatusPagamento

fun Pagamento.toPagamentoEntity(): PagamentoEntity {
    return PagamentoEntity(
        id = this.id,
        formaPagamento = this.formaPagamento?.name,
        valor = this.valor,
        status = this.status?.name
    )
}

fun Pagamento.toPagamentoDTO(): PagamentoDTO {
    return PagamentoDTO(
        id = this.id,
        formaPagamento = this.formaPagamento?.name,
        valor = this.valor,
        status = this.status?.name
    )
}

fun PagamentoDTO.toPagamentoModel(): Pagamento {
    return Pagamento(
        id = this.id,
        formaPagamento = this.formaPagamento?.let { FormaPagamento.valueOf(it) },
        valor = this.valor,
        status = this.status?.let { StatusPagamento.valueOf(it) }
    )
}