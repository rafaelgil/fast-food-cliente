package br.com.fiap.postech.fastfood.application.domain.extension

import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.PedidoEntity
import br.com.fiap.postech.fastfood.application.domain.dtos.PedidoDTO
import br.com.fiap.postech.fastfood.application.domain.models.Pedido

fun PedidoDTO.toPedidoModel() =
    Pedido(
        id = this.id,
        cliente = this.cliente?.toClienteModel(),
        lanche = this.lanche?.toProdutoModel(),
        bebida = this.bebida?.toProdutoModel(),
        acompanhamento = this.acompanhamento?.toProdutoModel(),
        sobremesa = this.sobremesa?.toProdutoModel(),
        dataPedido = this.dataPedido,
        status = this.status,
    )

fun Pedido.toPedidoEntity() =
    PedidoEntity(
        cliente = this.cliente?.toClienteEntity(),
        lanche = this.lanche?.toProdutoEntity(),
        bebida = this.bebida?.toProdutoEntity(),
        acompanhamento = this.acompanhamento?.toProdutoEntity(),
        sobremesa = this.sobremesa?.toProdutoEntity(),
        dataPedido = this.dataPedido,
        status = this.status,
    )

fun PedidoEntity.toPedidoModel(): Pedido {
    return Pedido(
        id = this.id,
        cliente = this.cliente?.toClienteModel(),
        lanche = this.lanche?.toProdutoModel(),
        bebida = this.bebida?.toProdutoModel(),
        acompanhamento = this.acompanhamento?.toProdutoModel(),
        sobremesa = this.sobremesa?.toProdutoModel(),
        dataPedido = this.dataPedido,
        status = this.status
    )
}

fun Pedido.toPedidoDTO(): PedidoDTO {
    return PedidoDTO(
        id = this.id,
        cliente = this.cliente?.toClienteDTO(),
        lanche = this.lanche?.toProdutoDTO(),
        bebida = this.bebida?.toProdutoDTO(),
        acompanhamento = this.acompanhamento?.toProdutoDTO(),
        sobremesa = this.sobremesa?.toProdutoDTO(),
        dataPedido = this.dataPedido,
        status = this.status,
    )
}