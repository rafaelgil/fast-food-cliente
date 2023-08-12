package br.com.fiap.postech.fastfood.application.domain.services

import br.com.fiap.postech.fastfood.application.domain.dtos.PedidoDTO
import br.com.fiap.postech.fastfood.application.domain.dtos.PedidoResponseDTO
import br.com.fiap.postech.fastfood.application.domain.extension.toPedidoDTO
import br.com.fiap.postech.fastfood.application.domain.extension.toPedidoModel
import br.com.fiap.postech.fastfood.domain.valueObjets.StatusPedido
import br.com.fiap.postech.fastfood.application.ports.interfaces.PedidoServicePort
import br.com.fiap.postech.fastfood.application.ports.repositories.PedidoRepositoryPort
import java.time.LocalDateTime
import java.util.*

class PedidoServiceImpl(
    private val pedidoRepositoryPort: PedidoRepositoryPort,
): PedidoServicePort {

    override fun cadastrar(pedidoDTO: PedidoDTO): PedidoResponseDTO {
        pedidoDTO.data = LocalDateTime.now()
        pedidoDTO.status = StatusPedido.INICIADO

        return pedidoRepositoryPort.cadastrar(pedidoDTO.toPedidoModel())
    }

    override fun atualizar(id: UUID, pedidoDTO: PedidoDTO): PedidoResponseDTO {
        return pedidoRepositoryPort.atualizar(pedidoDTO.toPedidoModel(id))
    }

    override fun listar(): List<PedidoDTO> {
        val pedidos = pedidoRepositoryPort.listar()
        return pedidos.map { it.toPedidoDTO() }
    }
}