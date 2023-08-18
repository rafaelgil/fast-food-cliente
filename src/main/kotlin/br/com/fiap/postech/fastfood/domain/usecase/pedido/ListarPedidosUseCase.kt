package br.com.fiap.postech.fastfood.domain.usecase.pedido

import br.com.fiap.postech.fastfood.domain.entity.Pedido
import br.com.fiap.postech.fastfood.domain.repository.PedidoRepository

class ListarPedidosUseCase(
    private val pedidoRepository: PedidoRepository
) {
    fun execute(): List<Pedido> {
        return pedidoRepository.listar()
    }
}