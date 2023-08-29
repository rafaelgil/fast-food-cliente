package br.com.fiap.postech.fastfood.domain.usecase.pedido

import br.com.fiap.postech.fastfood.adapter.presenter.StatusPedidoResponse
import br.com.fiap.postech.fastfood.adapter.presenter.toStatusResponse
import br.com.fiap.postech.fastfood.domain.repository.PedidoRepository
import br.com.fiap.postech.fastfood.domain.valueObjets.StatusPedido

class ListarTodosPedidosUseCase(
    private val pedidoRepository: PedidoRepository
) {
    fun execute(): List<StatusPedidoResponse> {
       val pedidos = pedidoRepository.listarPedidosRecebidos().map { it.toStatusResponse() }

       val pedidosProntos = pedidos.filter { it.status == StatusPedido.PRONTO.status }
       val pedidosEmPreparacao = pedidos.filter { it.status == StatusPedido.EM_PREPARACAO.status }
       val pedidosRecebidos = pedidos.filter { it.status == StatusPedido.RECEBIDO.status }

       val listaPedidosResult = mutableListOf<StatusPedidoResponse>()
       listaPedidosResult.addAll(pedidosProntos)
       listaPedidosResult.addAll(pedidosEmPreparacao)
       listaPedidosResult.addAll(pedidosRecebidos)

       return  listaPedidosResult
    }

}