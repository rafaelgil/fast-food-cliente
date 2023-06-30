package br.com.fiap.postech.fastfood.adapter.inbound.extension

import br.com.fiap.postech.fastfood.adapter.inbound.request.CheckoutRequest
import br.com.fiap.postech.fastfood.application.domain.dtos.CheckoutDTO
import br.com.fiap.postech.fastfood.application.domain.dtos.PedidoDTO
import br.com.fiap.postech.fastfood.application.domain.valueObjets.StatusCheckout
import java.time.LocalDateTime

fun CheckoutRequest.toCheckoutDTO(): CheckoutDTO {
    return CheckoutDTO(
        pedido = PedidoDTO(id = this.idPedido, data = null, status = null, acompanhamento = null, bebida = null, cliente = null, lanche = null, sobremesa = null),
        status = StatusCheckout.ENVIADO.name,
        data = LocalDateTime.now()
    )
}