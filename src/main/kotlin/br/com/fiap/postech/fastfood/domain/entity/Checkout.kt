package br.com.fiap.postech.fastfood.domain.entity

import br.com.fiap.postech.fastfood.domain.valueObjets.StatusCheckout
import java.time.LocalDateTime
import java.util.*

data class Checkout (
    var id: UUID? = null,
    var pedido: Pedido? = null,
    var status: StatusCheckout? = null,
    var pagamento: Pagamento? = null,
    var data: LocalDateTime? = null
)