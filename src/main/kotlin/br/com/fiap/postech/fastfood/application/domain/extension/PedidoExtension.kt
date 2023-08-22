package br.com.fiap.postech.fastfood.application.domain.extension

import br.com.fiap.postech.fastfood.application.domain.dtos.PedidoDTO
import br.com.fiap.postech.fastfood.domain.entity.Pedido
import br.com.fiap.postech.fastfood.domain.valueObjets.StatusPedido
import java.util.*

fun PedidoDTO.toPedidoModel(id: UUID? = null) =
    Pedido(
        id = id,
        cliente = this.cliente!!.toClienteModel(),
        data = this.data!!,
        status = StatusPedido.INICIADO,
    )

fun Pedido.toPedidoDTO(): PedidoDTO {
    return PedidoDTO(
        id = this.id,
        cliente = this.cliente!!.toClienteDTO(),
        lanche = null,
        bebida = null,
        acompanhamento = null,
        sobremesa = null,
        data = this.data,
        status = StatusPedido.INICIADO,
        clienteId = null,
        lancheId = null,
        bebidaId = null,
        acompanhamentoId = null,
        sobremesaId = null,
    )
}