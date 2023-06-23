package br.com.fiap.postech.fastfood.application.domain.services

import br.com.fiap.postech.fastfood.application.domain.dtos.PedidoDTO
import br.com.fiap.postech.fastfood.application.domain.extension.toPedidoDTO
import br.com.fiap.postech.fastfood.application.domain.extension.toPedidoModel
import br.com.fiap.postech.fastfood.application.ports.interfaces.PedidoServicePort
import br.com.fiap.postech.fastfood.application.ports.repositories.PedidoRepositoryPort

class PedidoServiceImpl(
    private val pedidoRepositoryPort: PedidoRepositoryPort
): PedidoServicePort {

    override fun cadastrar(pedidoDTO: PedidoDTO) {
        pedidoRepositoryPort.cadastrar(pedidoDTO.toPedidoModel())
    }

    override fun listar(): List<PedidoDTO> {
        val pedidos = pedidoRepositoryPort.listar()
        return pedidos.map { it.toPedidoDTO() }
    }
}