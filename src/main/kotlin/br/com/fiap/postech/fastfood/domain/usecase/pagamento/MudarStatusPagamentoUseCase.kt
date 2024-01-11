package br.com.fiap.postech.fastfood.domain.usecase.pagamento

import br.com.fiap.postech.fastfood.domain.entity.Pagamento
import br.com.fiap.postech.fastfood.domain.repository.PagamentoRepository
import br.com.fiap.postech.fastfood.domain.valueObjets.StatusPagamento
import java.util.*

//TODO TIRAR
class MudarStatusPagamentoUseCase(
    private val pagamentoRepository: PagamentoRepository
) {

    fun executa(qrCodeId: UUID, statusPagamento: StatusPagamento): Pagamento {

        return Pagamento(UUID.randomUUID(), StatusPagamento.AGUARDANDO_PAGAMENTO)

    }

}