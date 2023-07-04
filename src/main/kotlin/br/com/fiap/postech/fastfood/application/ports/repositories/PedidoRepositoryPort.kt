package br.com.fiap.postech.fastfood.application.ports.repositories

import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.PedidoEntity
import br.com.fiap.postech.fastfood.application.domain.dtos.PedidoDTO
import br.com.fiap.postech.fastfood.application.domain.dtos.PedidoResponseDTO
import br.com.fiap.postech.fastfood.application.domain.models.Pedido
import java.util.*

interface PedidoRepositoryPort {

    fun cadastrar(pedido: Pedido): PedidoResponseDTO
    fun atualizar(pedido: Pedido): PedidoResponseDTO
    fun listar(): List<Pedido>
    fun busca(id: UUID): Optional<Pedido>
}