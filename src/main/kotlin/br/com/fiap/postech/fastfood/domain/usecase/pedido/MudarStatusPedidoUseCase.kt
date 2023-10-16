package br.com.fiap.postech.fastfood.domain.usecase.pedido

import br.com.fiap.postech.fastfood.domain.exception.NotFoundEntityException
import br.com.fiap.postech.fastfood.domain.entity.Pedido
import br.com.fiap.postech.fastfood.domain.repository.PedidoRepository
import br.com.fiap.postech.fastfood.domain.valueObjets.StatusPedido
import java.util.*

class MudarStatusPedidoUseCase(
    private val pedidoRepository: PedidoRepository,
) {
    fun executa(id: UUID, statusPedido: StatusPedido ): Pedido {

        val pedido = pedidoRepository.buscarPorId(id)
            ?: throw NotFoundEntityException("Pedido ${id} não encontrado")

        pedido.mudarStatus(statusPedido)

        return pedidoRepository.atualizar(pedido)
    }
}