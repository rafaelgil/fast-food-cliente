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
        data = this.data,
        status = this.status,
    )

fun Pedido.toPedidoEntity() =
    PedidoEntity(
        id = this.id,
        cliente = this.cliente?.toClienteEntity(),
        lanche = this.lanche?.toProdutoEntity(),
        bebida = this.bebida?.toProdutoEntity(),
        acompanhamento = this.acompanhamento?.toProdutoEntity(),
        sobremesa = this.sobremesa?.toProdutoEntity(),
        data = this.data,
        status = this.status,
        checkout = null
    )

fun PedidoEntity.toPedidoModel(): Pedido {
    return Pedido(
        id = this.id,
        cliente = this.cliente?.toClienteModel(),
        lanche = this.lanche?.toProdutoModel(),
        bebida = this.bebida?.toProdutoModel(),
        acompanhamento = this.acompanhamento?.toProdutoModel(),
        sobremesa = this.sobremesa?.toProdutoModel(),
        data = this.data,
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
        data = this.data,
        status = this.status,
    )
}

fun PedidoEntity.toPedidoDTO(): PedidoDTO {
    return PedidoDTO(
        id = this.id,
        cliente = this.cliente?.toClienteDTO(),
        lanche = this.lanche?.toProdutoDTO(),
        bebida = this.bebida?.toProdutoDTO(),
        acompanhamento = this.acompanhamento?.toProdutoDTO(),
        sobremesa = this.sobremesa?.toProdutoDTO(),
        data = this.data,
        status = this.status
    )
}

fun PedidoDTO.toPedidoEntity(): PedidoEntity {
    return PedidoEntity(
        id = this.id,
        cliente = this.cliente?.toClienteEntity(),
        lanche = this.lanche?.toProdutoEntity(),
        bebida = this.bebida?.toProdutoEntity(),
        acompanhamento = this.acompanhamento?.toProdutoEntity(),
        sobremesa = this.sobremesa?.toProdutoEntity(),
        data = this.data,
        status = this.status,
        checkout = null
    )
}