package br.com.fiap.postech.fastfood.domain.usecase.pagamento

import br.com.fiap.postech.fastfood.adapter.gateway.apis.pagamento.PagamentoClient
import br.com.fiap.postech.fastfood.adapter.presenter.toPagamento
import br.com.fiap.postech.fastfood.domain.entity.Pagamento
import br.com.fiap.postech.fastfood.domain.entity.Pedido
import org.springframework.beans.factory.annotation.Autowired

class GerarPagamentoUseCase(
    @Autowired
    val pagamentoClient: PagamentoClient
) {

    fun executa(pedido: Pedido): Pagamento {
        return pagamentoClient.gerarPagamento(pedido).toPagamento()
    }

}