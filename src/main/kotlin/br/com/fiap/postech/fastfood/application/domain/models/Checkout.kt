package br.com.fiap.postech.fastfood.application.domain.models

import br.com.fiap.postech.fastfood.application.domain.valueObjets.StatusCheckout
import java.time.LocalDateTime
import java.util.*

data class Checkout (
    var id: UUID? = null,
    var pedido: Pedido,
    var status: StatusCheckout,
    var data: LocalDateTime
)