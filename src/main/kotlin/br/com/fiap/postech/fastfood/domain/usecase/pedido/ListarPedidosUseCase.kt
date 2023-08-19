package br.com.fiap.postech.fastfood.domain.usecase.pedido

import br.com.fiap.postech.fastfood.application.domain.exception.NotFoundEntityException
import br.com.fiap.postech.fastfood.domain.entity.Pedido
import br.com.fiap.postech.fastfood.domain.repository.PedidoRepository
import java.util.UUID

class ListarPedidosUseCase(
    private val pedidoRepository: PedidoRepository
) {
    fun execute(id: UUID): Pedido {
        val opPedido = pedidoRepository.busca(id)

        if(!opPedido.isPresent) {
            throw NotFoundEntityException("Pedido ${id} não encontado")
        }

        return opPedido.get()
    }
}