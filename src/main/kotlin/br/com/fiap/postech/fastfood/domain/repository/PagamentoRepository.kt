package br.com.fiap.postech.fastfood.domain.repository

import br.com.fiap.postech.fastfood.domain.entity.Pagamento
import java.util.*

interface PagamentoRepository {
    fun buscarPagamentoPorQrCodeId(id: UUID): Pagamento?
    fun atualizarPagamento(pagamento: Pagamento): Pagamento
    fun buscarPorId(id: UUID): Pagamento?

}