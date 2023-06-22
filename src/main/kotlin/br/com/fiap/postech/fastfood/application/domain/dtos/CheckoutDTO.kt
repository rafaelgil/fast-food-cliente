package br.com.fiap.postech.fastfood.application.domain.dtos

import br.com.fiap.postech.fastfood.application.domain.valueObjets.StatusCheckout
import java.util.*

data class CheckoutDTO(

    var id: UUID? = null,
    var pedido: PedidoDTO,
    var status: StatusCheckout
)
