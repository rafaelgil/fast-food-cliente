package br.com.fiap.postech.fastfood.adapter.gateway

import br.com.fiap.postech.fastfood.adapter.gateway.jpa.PagamentoRepositoryJpa
import br.com.fiap.postech.fastfood.adapter.presenter.toPagamento
import br.com.fiap.postech.fastfood.adapter.presenter.toPagamentoSchema
import br.com.fiap.postech.fastfood.domain.entity.Pagamento
import br.com.fiap.postech.fastfood.domain.repository.PagamentoRepository
import java.util.*

class PagamentoRepositoryImpl(
    private val pagamentoRepositoryJpa: PagamentoRepositoryJpa
): PagamentoRepository {
    override fun buscarPagamentoPorQrCodeId(id: UUID): Pagamento? {
        val opPagamento = pagamentoRepositoryJpa.findByQrCodeId(id)

        if(opPagamento.isPresent) {
            return opPagamento.get().toPagamento()
        }

        return null
    }

    override fun atualizarPagamento(pagamento: Pagamento) =
        pagamentoRepositoryJpa.save(pagamento.toPagamentoSchema(status = pagamento.status)).toPagamento()

    override fun buscarPorId(id: UUID): Pagamento? {
        val opPagamento = pagamentoRepositoryJpa.findById(id)

        if(opPagamento.isPresent) {
            return opPagamento.get().toPagamento()
        }

        return null
    }

}