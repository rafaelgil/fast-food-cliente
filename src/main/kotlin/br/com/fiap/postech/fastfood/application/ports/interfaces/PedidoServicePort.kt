package br.com.fiap.postech.fastfood.application.ports.interfaces

import br.com.fiap.postech.fastfood.application.domain.dtos.PedidoDTO

interface PedidoServicePort {

    fun cadastrar(pedido: PedidoDTO)
    fun listar(): List<PedidoDTO>
}