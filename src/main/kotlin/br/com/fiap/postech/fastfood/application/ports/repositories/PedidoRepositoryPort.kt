package br.com.fiap.postech.fastfood.application.ports.repositories

import br.com.fiap.postech.fastfood.application.domain.dtos.PedidoResponseDTO
import br.com.fiap.postech.fastfood.domain.entity.Pedido
import java.util.*

interface PedidoRepositoryPort {

    fun cadastrar(pedido: Pedido): PedidoResponseDTO
    fun atualizar(pedido: Pedido): PedidoResponseDTO
    fun listar(): List<Pedido>
    fun busca(id: UUID): Optional<Pedido>
}