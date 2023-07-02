package br.com.fiap.postech.fastfood.application.ports.interfaces

import br.com.fiap.postech.fastfood.application.domain.dtos.PedidoDTO
import br.com.fiap.postech.fastfood.application.domain.models.Pedido
import java.util.*

interface PedidoServicePort {

    fun cadastrar(pedido: PedidoDTO): PedidoDTO
    fun listar(): List<PedidoDTO>
}