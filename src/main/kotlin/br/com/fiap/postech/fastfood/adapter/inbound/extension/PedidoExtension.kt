package br.com.fiap.postech.fastfood.adapter.inbound.extension

import br.com.fiap.postech.fastfood.adapter.inbound.request.PedidoRequest
import br.com.fiap.postech.fastfood.adapter.inbound.response.PedidoResponse
import br.com.fiap.postech.fastfood.application.domain.dtos.PedidoDTO
import br.com.fiap.postech.fastfood.application.domain.dtos.PedidoResponseDTO

fun PedidoRequest.toPedidoDTO(): PedidoDTO {
    return PedidoDTO(
        id = this.id,
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

fun PedidoResponseDTO.toPedidoResponse(): PedidoResponse {
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