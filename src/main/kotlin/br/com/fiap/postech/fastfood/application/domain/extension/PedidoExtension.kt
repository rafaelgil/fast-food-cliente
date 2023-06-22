package br.com.fiap.postech.fastfood.application.domain.extension

import br.com.fiap.postech.fastfood.application.domain.dtos.PedidoDTO
import br.com.fiap.postech.fastfood.application.domain.models.Pedido

fun PedidoDTO.toPedidoModel(): Pedido {
    return Pedido(
        id = this.id
    )
}