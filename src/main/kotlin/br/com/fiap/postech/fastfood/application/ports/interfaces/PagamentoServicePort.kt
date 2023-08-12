package br.com.fiap.postech.fastfood.application.ports.interfaces

import br.com.fiap.postech.fastfood.application.domain.dtos.PagamentoDTO
import br.com.fiap.postech.fastfood.domain.entity.Pagamento

interface PagamentoServicePort {

    fun efetuaPagamento(pagamentoDTO: PagamentoDTO): Pagamento
}