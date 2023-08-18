package br.com.fiap.postech.fastfood.domain.repository

import br.com.fiap.postech.fastfood.domain.entity.Pedido

interface PedidoRepository {

    fun listar(): List<Pedido>
}