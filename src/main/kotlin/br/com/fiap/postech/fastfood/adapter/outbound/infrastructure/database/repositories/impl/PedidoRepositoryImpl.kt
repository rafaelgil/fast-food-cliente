package br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.repositories.impl

import br.com.fiap.postech.fastfood.adapter.inbound.extension.toPedidoEntity
import br.com.fiap.postech.fastfood.adapter.inbound.extension.toPedidoModel
import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.PedidoEntity
import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.repositories.ClienteRepositorySpring
import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.repositories.PedidoRepositorySpring
import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.extension.toClienteModel
import br.com.fiap.postech.fastfood.application.domain.dtos.PedidoDTO
import br.com.fiap.postech.fastfood.application.domain.exception.NotFoundEntityException
import br.com.fiap.postech.fastfood.application.domain.extension.toClienteEntity
import br.com.fiap.postech.fastfood.application.domain.extension.toPedidoDTO
import br.com.fiap.postech.fastfood.application.domain.extension.toPedidoModel
import br.com.fiap.postech.fastfood.application.domain.models.Pedido
import br.com.fiap.postech.fastfood.application.ports.repositories.PedidoRepositoryPort
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Component
import java.util.*

@Component
class PedidoRepositoryImpl(
    private val pedidoRepositorySpring: PedidoRepositorySpring,
    private val clienteRepositorySpring: ClienteRepositorySpring,
    private val entityManager: EntityManager
): PedidoRepositoryPort {

    override fun cadastrar(pedido: Pedido): PedidoDTO {
        val cliente = pedido.cliente

        if (cliente != null && cliente.id != null) {
            val clienteExistente = clienteRepositorySpring.findById(cliente.id!!)

            if (clienteExistente.isPresent) {
                pedido.cliente = clienteExistente.get().toClienteModel()
            } else {
                throw NotFoundEntityException("Cliente não encontrado")
            }
        } else {
            throw NotFoundEntityException("Cliente não encontrado")
        }

        var pedidoEntity: PedidoEntity = pedidoRepositorySpring.save(pedido.toPedidoEntity())
        return pedidoEntity.toPedidoModel().toPedidoDTO()
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