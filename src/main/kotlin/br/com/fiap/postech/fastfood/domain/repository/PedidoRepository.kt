package br.com.fiap.postech.fastfood.domain.repository

import br.com.fiap.postech.fastfood.domain.entity.Pedido
import java.util.*

interface PedidoRepository {

    fun cadastrar(pedido: Pedido): Pedido
    fun atualizar(pedido: Pedido): Pedido
    fun listar(): List<Pedido>
    fun busca(id: UUID): Optional<Pedido>
    fun existePedido(id: UUID): Boolean

}