package br.com.fiap.postech.fastfood.adapter.gateway

import br.com.fiap.postech.fastfood.adapter.gateway.jpa.PedidoRepositoryJpa
import br.com.fiap.postech.fastfood.domain.entity.Pedido
import br.com.fiap.postech.fastfood.adapter.presenter.toPedido
import br.com.fiap.postech.fastfood.adapter.presenter.toPedidoSchema
import br.com.fiap.postech.fastfood.domain.repository.PedidoRepository
import java.util.*

class PedidoRepositoryImpl(
    private val pedidoRepositoryJpa: PedidoRepositoryJpa
): PedidoRepository {
    override fun cadastrar(pedido: Pedido) =
        pedidoRepositoryJpa.save(pedido.toPedidoSchema()).toPedido()
    override fun atualizar(pedido: Pedido) =
        this.cadastrar(pedido)

    override fun listar(): List<Pedido> {
        TODO("Not yet implemented")
        //return pedidoRepositoryJpa.findAll().map{ it.toPedido() }
    }

    override fun buscarPorId(id: UUID): Pedido? {
        val opPedido = pedidoRepositoryJpa.findById(id)

       return opPedido.takeIf { it.isPresent }.let {
            opPedido.get().toPedido()
        }

    }

    override fun existePedido(id: UUID): Boolean {
        TODO("Not yet implemented")
    }

}