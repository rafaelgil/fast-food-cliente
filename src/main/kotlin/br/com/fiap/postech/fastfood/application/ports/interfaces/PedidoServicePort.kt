package br.com.fiap.postech.fastfood.application.ports.interfaces

import br.com.fiap.postech.fastfood.application.domain.dtos.PedidoDTO
import br.com.fiap.postech.fastfood.application.domain.dtos.PedidoResponseDTO
import java.util.*

interface PedidoServicePort {

    fun cadastrar(pedido: PedidoDTO): PedidoResponseDTO
    fun atualizar(id: UUID, pedido: PedidoDTO): PedidoResponseDTO
    fun listar(): List<PedidoDTO>
}