package br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.extension

import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.PagamentoEntity
import br.com.fiap.postech.fastfood.application.domain.dtos.PagamentoDTO
import br.com.fiap.postech.fastfood.domain.entity.Pagamento
import br.com.fiap.postech.fastfood.domain.valueObjets.FormaPagamento
import br.com.fiap.postech.fastfood.domain.valueObjets.StatusPagamento

fun Pagamento.toPagamentoEntity(): PagamentoEntity {
    return PagamentoEntity(
        id = this.id,
        formaPagamento = this.formaPagamento?.name,
        valor = this.valor,
        status = this.status?.name
    )
}

fun PagamentoEntity.toPagamentoDTO(): PagamentoDTO {
    return PagamentoDTO(
        id = this.id,
        formaPagamento = this.formaPagamento,
        valor = this.valor,
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