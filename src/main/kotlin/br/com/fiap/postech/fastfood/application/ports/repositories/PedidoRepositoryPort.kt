package br.com.fiap.postech.fastfood.application.ports.repositories

import br.com.fiap.postech.fastfood.application.domain.dtos.PedidoDTO
import br.com.fiap.postech.fastfood.application.domain.models.Pedido

interface PedidoRepositoryPort {

    fun cadastrar(pedido: Pedido)
    fun listar(): List<Pedido>
}