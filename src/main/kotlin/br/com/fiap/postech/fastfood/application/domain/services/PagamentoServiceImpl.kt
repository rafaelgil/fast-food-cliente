package br.com.fiap.postech.fastfood.application.domain.services

import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.extension.toPagamentoModel
import br.com.fiap.postech.fastfood.application.domain.dtos.PagamentoDTO
import br.com.fiap.postech.fastfood.application.domain.extension.toPagamentoModel
import br.com.fiap.postech.fastfood.domain.entity.Pagamento
import br.com.fiap.postech.fastfood.domain.valueObjets.StatusPagamento
import br.com.fiap.postech.fastfood.application.ports.interfaces.PagamentoServicePort
import br.com.fiap.postech.fastfood.application.ports.repositories.PagamentoRepositoryPort

class PagamentoServiceImpl(
    private var pagamentoRepositoryPort: PagamentoRepositoryPort
): PagamentoServicePort {

    override fun efetuaPagamento(pagamentoDTO: PagamentoDTO): Pagamento {

        println("Implementação fake para o pagamento")
        //pagamentoDTO.status = StatusPagamento.APROVADO.name
        var pagamentoEntity = pagamentoRepositoryPort.efetuaPagamento(pagamentoDTO.toPagamentoModel())

        return pagamentoEntity.toPagamentoModel()
    }
}