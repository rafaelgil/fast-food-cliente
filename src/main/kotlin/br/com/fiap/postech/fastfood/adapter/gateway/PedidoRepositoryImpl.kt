package br.com.fiap.postech.fastfood.adapter.gateway

import br.com.fiap.postech.fastfood.adapter.gateway.jpa.PedidoRepositoryJpa
import br.com.fiap.postech.fastfood.domain.entity.Pedido
import br.com.fiap.postech.fastfood.adapter.presenter.toPedido
import br.com.fiap.postech.fastfood.domain.repository.PedidoRepository
import java.util.*

class PedidoRepositoryImpl(
    private val pedidoRepositoryJpa: PedidoRepositoryJpa
): PedidoRepository {
    override fun listar(): List<Pedido> {
        return pedidoRepositoryJpa.findAll().map{ it.toPedido() }
    }
}