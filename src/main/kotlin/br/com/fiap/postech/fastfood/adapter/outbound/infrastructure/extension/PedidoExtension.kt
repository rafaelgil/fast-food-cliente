package br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.extension

import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.PedidoEntity
import br.com.fiap.postech.fastfood.application.domain.dtos.PedidoDTO
import br.com.fiap.postech.fastfood.application.domain.dtos.PedidoResponseDTO
import br.com.fiap.postech.fastfood.application.domain.extension.toProdutoDTO
import br.com.fiap.postech.fastfood.application.domain.extension.toProdutoModel
import br.com.fiap.postech.fastfood.domain.entity.Pedido
import br.com.fiap.postech.fastfood.domain.valueObjets.StatusPedido

fun Pedido.toPedidoEntity() =
    PedidoEntity(
        id = this.id,
        cliente = this.cliente?.toClienteEntity(),
        lanche = null,
        bebida = null,
        acompanhamento = null,
        sobremesa = null,
        data = this.data,
        status = StatusPedido.INICIADO,
        checkout = null,
        //clienteId = this.clienteId,
        //lancheId = this.lancheId,
        //bebidaId = this.bebidaId,
        //acompanhamentoId = this.acompanhamentoId,
        //sobremesaId = this.sobremesaId
    )

fun PedidoEntity.toPedidoModel(): Pedido {
    return Pedido(
        id = this.id,
        cliente = this.cliente!!.toClienteModel(),
        //lanche = this.lanche?.toProdutoModel(),
        //bebida = this.bebida?.toProdutoModel(),
        //acompanhamento = this.acompanhamento?.toProdutoModel(),
        //sobremesa = this.sobremesa?.toProdutoModel(),
        data = this.data!!,
        status = StatusPedido.INICIADO,
        //clienteId = this.clienteId,
        //lancheId = this.lancheId,
        //bebidaId = this.bebidaId,
        //acompanhamentoId = this.acompanhamentoId,
        //sobremesaId = this.sobremesaId
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
        status = this.status,
        clienteId = this.clienteId,
        lancheId = this.lancheId,
        bebidaId = this.bebidaId,
        acompanhamentoId = this.acompanhamentoId,
        sobremesaId = this.sobremesaId
    )
}

fun PedidoEntity.toPedidoResponseDTO(): PedidoResponseDTO {
    return PedidoResponseDTO(
        id = this.id,
        cliente = this.cliente?.toClienteResponseDTO(),
        lanche = this.lanche?.toProdutoDTO(),
        bebida = this.bebida?.toProdutoDTO(),
        acompanhamento = this.acompanhamento?.toProdutoDTO(),
        sobremesa = this.sobremesa?.toProdutoDTO(),
        data = this.data,
        status = this.status,
    )
}