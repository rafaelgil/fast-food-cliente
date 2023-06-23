package br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.repositories.impl

import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.repositories.PedidoRepositorySpring
import br.com.fiap.postech.fastfood.application.domain.extension.toClienteEntity
import br.com.fiap.postech.fastfood.application.domain.extension.toPedidoEntity
import br.com.fiap.postech.fastfood.application.domain.extension.toPedidoModel
import br.com.fiap.postech.fastfood.application.domain.models.Cliente
import br.com.fiap.postech.fastfood.application.domain.models.Pedido
import br.com.fiap.postech.fastfood.application.ports.repositories.PedidoRepositoryPort
import org.springframework.stereotype.Component

@Component
class PedidoRepositoryImpl(
    private val pedidoRepositorySpring: PedidoRepositorySpring
): PedidoRepositoryPort {

    override fun cadastrar(pedido: Pedido) {
        pedidoRepositorySpring.save(pedido.toPedidoEntity())
    }

    override fun listar(): List<Pedido> {
        val pedidosEntities = pedidoRepositorySpring.findAll()
        return pedidosEntities.map { it.toPedidoModel() }
    }
}