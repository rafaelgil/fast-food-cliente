package br.com.fiap.postech.fastfood.domain.usecase.pedido

import br.com.fiap.postech.fastfood.application.domain.exception.NotFoundEntityException
import br.com.fiap.postech.fastfood.domain.repository.PedidoRepository
import java.util.*

class ListarPedidoUseCase(
    private val pedidoRepository: PedidoRepository
) {
    fun execute(id: UUID) = pedidoRepository.buscarPorId(id)
        ?: throw NotFoundEntityException("Pedido ${id} não encontrado")

}