package br.com.fiap.postech.fastfood.domain.usecase.pedido

import br.com.fiap.postech.fastfood.application.domain.exception.NotFoundEntityException
import br.com.fiap.postech.fastfood.domain.entity.Pedido
import br.com.fiap.postech.fastfood.domain.repository.PedidoRepository
import br.com.fiap.postech.fastfood.domain.valueObjets.StatusPedido
import java.util.UUID

class MudarStatusPedidoUseCase(
    private val pedidoRepository: PedidoRepository,
) {
    fun executa(id: UUID, statusPedido: StatusPedido ): Pedido {
        val opPedido = pedidoRepository.busca(id)

        if(opPedido.isEmpty) {
            throw NotFoundEntityException("Pedido ${id} não encontrado")
        }

        val pedido = opPedido.get()
        pedido.mudarStatus(statusPedido)

        return pedidoRepository.atualizar(pedido)
    }
}