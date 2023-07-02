package br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.repositories.impl

import br.com.fiap.postech.fastfood.adapter.inbound.extension.toPedidoDTO
import br.com.fiap.postech.fastfood.adapter.inbound.extension.toPedidoEntity
import br.com.fiap.postech.fastfood.adapter.inbound.extension.toPedidoModel
import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.PedidoEntity
import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.repositories.ClienteRepositorySpring
import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.repositories.PedidoRepositorySpring
import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.repositories.ProdutoRepositorySpring
import br.com.fiap.postech.fastfood.application.domain.dtos.PedidoDTO
import br.com.fiap.postech.fastfood.application.domain.models.Pedido
import br.com.fiap.postech.fastfood.application.ports.repositories.PedidoRepositoryPort
import org.springframework.stereotype.Component
import java.util.*

@Component
class PedidoRepositoryImpl(
    private val pedidoRepositorySpring: PedidoRepositorySpring,
    private val clienteRepositorySpring: ClienteRepositorySpring,
    private val produtoRepositorySpring: ProdutoRepositorySpring,
): PedidoRepositoryPort {

    override fun cadastrar(pedido: Pedido): PedidoDTO {
        val pedidoEntity: PedidoEntity = pedidoRepositorySpring.save(pedido.toPedidoEntity())

        pedidoEntity.cliente = if (pedidoEntity.clienteId != null) clienteRepositorySpring.findById(pedidoEntity.clienteId!!).orElse(null) else null
        pedidoEntity.lanche = if (pedidoEntity.lancheId != null) produtoRepositorySpring.findById(pedidoEntity.lancheId!!).orElse(null) else null
        pedidoEntity.bebida = if (pedidoEntity.bebidaId != null) produtoRepositorySpring.findById(pedidoEntity.bebidaId!!).orElse(null) else null
        pedidoEntity.acompanhamento = if (pedidoEntity.acompanhamentoId != null) produtoRepositorySpring.findById(pedidoEntity.acompanhamentoId!!).orElse(null) else null
        pedidoEntity.sobremesa = if (pedidoEntity.sobremesaId != null) produtoRepositorySpring.findById(pedidoEntity.sobremesaId!!).orElse(null) else null

        return pedidoEntity.toPedidoDTO()
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