package br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.repositories.impl

import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.PedidoEntity
import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.repositories.PedidoRepositorySpring
import br.com.fiap.postech.fastfood.application.domain.dtos.PedidoDTO
import br.com.fiap.postech.fastfood.application.domain.exception.NotFoundEntityException
import br.com.fiap.postech.fastfood.application.domain.extension.toPedidoDTO
import br.com.fiap.postech.fastfood.application.domain.extension.toPedidoEntity
import br.com.fiap.postech.fastfood.application.domain.extension.toPedidoModel
import br.com.fiap.postech.fastfood.application.domain.models.Pedido
import br.com.fiap.postech.fastfood.application.ports.repositories.PedidoRepositoryPort
import org.springframework.stereotype.Component
import java.util.*

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

    override fun busca(id: UUID): Optional<Pedido> {
        val pedidoEntity = pedidoRepositorySpring.findById(id)
        if (pedidoEntity.isPresent) {
            var pedido = pedidoEntity.get()
            return Optional.of(pedido.toPedidoModel())
        }
        return Optional.ofNullable(null)
    }
}