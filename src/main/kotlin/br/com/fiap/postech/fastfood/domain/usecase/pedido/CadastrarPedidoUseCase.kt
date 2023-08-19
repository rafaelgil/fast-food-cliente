package br.com.fiap.postech.fastfood.domain.usecase.pedido

import br.com.fiap.postech.fastfood.domain.entity.Pedido
import br.com.fiap.postech.fastfood.domain.repository.PedidoRepository

class CadastrarPedidoUseCase(
    private val pedidoRepository: PedidoRepository
) {
    fun executa(pedido: Pedido):Pedido {
        //TODO fazer as validacoes se exite produto e cliente
        return pedidoRepository.cadastrar(pedido)
    }

}