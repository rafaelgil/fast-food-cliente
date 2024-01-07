package br.com.fiap.postech.fastfood.adapter.gateway

import br.com.fiap.postech.fastfood.adapter.gateway.jpa.PagamentoRepositoryJpa
import br.com.fiap.postech.fastfood.adapter.presenter.toPagamento
import br.com.fiap.postech.fastfood.domain.entity.Pagamento
import br.com.fiap.postech.fastfood.domain.repository.PagamentoRepository
import java.util.*

class PagamentoRepositoryImpl(
    private val pagamentoRepositoryJpa: PagamentoRepositoryJpa
): PagamentoRepository {

    override fun buscarPorId(id: UUID): Pagamento? {
        val opPagamento = pagamentoRepositoryJpa.findById(id)

        if(opPagamento.isPresent) {
            return opPagamento.get().toPagamento()
        }

        return null
    }

}