package br.com.fiap.postech.fastfood.adapter.inbound.extension

import br.com.fiap.postech.fastfood.adapter.inbound.request.PedidoRequest
import br.com.fiap.postech.fastfood.adapter.inbound.response.PedidoResponse
import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.PedidoEntity
import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.extension.toClienteDTO
import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.extension.toClienteModel
import br.com.fiap.postech.fastfood.application.domain.dtos.ClienteDTO
import br.com.fiap.postech.fastfood.application.domain.dtos.PedidoDTO
import br.com.fiap.postech.fastfood.application.domain.dtos.ProdutoDTO
import br.com.fiap.postech.fastfood.application.domain.extension.*
import br.com.fiap.postech.fastfood.application.domain.models.Pedido
import java.math.BigDecimal

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
        checkout = null,
        clienteId = this.clienteId,
        lancheId = this.lancheId,
        bebidaId = this.bebidaId,
        acompanhamentoId = this.acompanhamentoId,
        sobremesaId = this.sobremesaId
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
        status = this.status,
        clienteId = this.clienteId,
        lancheId = this.lancheId,
        bebidaId = this.bebidaId,
        acompanhamentoId = this.acompanhamentoId,
        sobremesaId = this.sobremesaId
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

fun PedidoRequest.toPedidoDTO(): PedidoDTO {
    return PedidoDTO(
        id = null,
        cliente = null,
        lanche = null,
        bebida = null,
        acompanhamento = null,
        sobremesa = null,
        data = null,
        status = null,
        clienteId = this.clienteId,
        lancheId = this.lancheId,
        bebidaId = this.bebidaId,
        acompanhamentoId = this.acompanhamentoId,
        sobremesaId = this.sobremesaId
    )
}

fun PedidoDTO.toPedidoResponse(): PedidoResponse {
    return PedidoResponse(
        id = this.id,
        cliente = this.cliente?.toClienteResponse(),
        lanche = this.lanche?.toProdutoResponse(),
        bebida = this.bebida?.toProdutoResponse(),
        acompanhamento = this.acompanhamento?.toProdutoResponse(),
        sobremesa = this.sobremesa?.toProdutoResponse(),
        data = this.data,
        status = this.status,
    )
}