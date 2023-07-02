package br.com.fiap.postech.fastfood.application.ports.repositories

import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.PagamentoEntity
import br.com.fiap.postech.fastfood.application.domain.models.Pagamento

interface PagamentoRepositoryPort {

    fun efetuaPagamento(pagamento: Pagamento): PagamentoEntity
}