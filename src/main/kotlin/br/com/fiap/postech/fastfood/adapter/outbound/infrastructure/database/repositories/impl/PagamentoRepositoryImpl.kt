package br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.repositories.impl

import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.PagamentoEntity
import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.repositories.PagamentoRepositorySpring
import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.extension.toPagamentoEntity
import br.com.fiap.postech.fastfood.domain.entity.Pagamento
import br.com.fiap.postech.fastfood.application.ports.repositories.PagamentoRepositoryPort
import org.springframework.stereotype.Component

@Component
class PagamentoRepositoryImpl(
    private val pagamentoRepositorySpring: PagamentoRepositorySpring
): PagamentoRepositoryPort {
    override fun efetuaPagamento(pagamento: Pagamento): PagamentoEntity {
        var pagamentoEntity = pagamentoRepositorySpring.save(pagamento.toPagamentoEntity())
        return pagamentoEntity
    }
}