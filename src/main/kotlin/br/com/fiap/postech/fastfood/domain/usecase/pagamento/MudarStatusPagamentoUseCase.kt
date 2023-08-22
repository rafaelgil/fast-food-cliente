package br.com.fiap.postech.fastfood.domain.usecase.pagamento

import br.com.fiap.postech.fastfood.application.domain.exception.NotFoundEntityException
import br.com.fiap.postech.fastfood.domain.entity.Pagamento
import br.com.fiap.postech.fastfood.domain.repository.PagamentoRepository
import br.com.fiap.postech.fastfood.domain.valueObjets.StatusPagamento
import java.util.*

class MudarStatusPagamentoUseCase(
    private val pagamentoRepository: PagamentoRepository
) {

    fun executa(qrCodeId: UUID, statusPagamento: StatusPagamento): Pagamento {
        val pagamento = pagamentoRepository.buscarPagamentoPorQrCodeId(qrCodeId)

        if(pagamento == null) {
            throw NotFoundEntityException("Pagamento com QrCodeId $qrCodeId não encontrado")
        }

        pagamento.mudarStatus(statusPagamento)

        return pagamentoRepository.atualizarPagamento(pagamento)

    }

}