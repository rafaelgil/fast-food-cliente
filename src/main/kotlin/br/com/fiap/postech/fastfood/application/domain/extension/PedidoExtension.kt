package br.com.fiap.postech.fastfood.application.domain.extension

import br.com.fiap.postech.fastfood.adapter.inbound.extension.toPedidoDTO
import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.extension.toClienteDTO
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
        clienteId = this.clienteId,
        lancheId = this.lancheId,
        bebidaId = this.bebidaId,
        acompanhamentoId = this.acompanhamentoId,
        sobremesaId = this.sobremesaId
    )

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
        clienteId = this.clienteId,
        lancheId = this.lancheId,
        bebidaId = this.bebidaId,
        acompanhamentoId = this.acompanhamentoId,
        sobremesaId = this.sobremesaId
    )
}