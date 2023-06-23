package br.com.fiap.postech.fastfood.application.domain.extension

import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.PedidoEntity
import br.com.fiap.postech.fastfood.application.domain.dtos.PedidoDTO
import br.com.fiap.postech.fastfood.application.domain.models.Pedido

fun PedidoDTO.toPedidoModel() =
    Pedido(
        id = this.id,
        clienteId = this.clienteId,
        lancheId = this.lancheId,
        bebidaId = this.bebidaId,
        acompanhamentoId = this.acompanhamentoId,
        sobremesaId = this.sobremesaId,
        dataPedido = this.dataPedido,
        status = this.status,
    )

fun Pedido.toPedidoEntity() =
    PedidoEntity(
        clienteId = this.clienteId,
        lancheId = this.lancheId,
        bebidaId = this.bebidaId,
        acompanhamentoId = this.acompanhamentoId,
        sobremesaId = this.sobremesaId,
        dataPedido = this.dataPedido,
        status = this.status,
    )

fun PedidoEntity.toPedidoModel(): Pedido {
    return Pedido(
        id = this.id,
        clienteId = this.clienteId,
        lancheId = this.lancheId,
        bebidaId = this.bebidaId,
        acompanhamentoId = this.acompanhamentoId,
        sobremesaId = this.sobremesaId,
        dataPedido = this.dataPedido,
        status = this.status,
    )
}

fun Pedido.toPedidoDTO(): PedidoDTO {
    return PedidoDTO(
        id = this.id,
        clienteId = this.clienteId,
        lancheId = this.lancheId,
        bebidaId = this.bebidaId,
        acompanhamentoId = this.acompanhamentoId,
        sobremesaId = this.sobremesaId,
        dataPedido = this.dataPedido,
        status = this.status,
    )
}