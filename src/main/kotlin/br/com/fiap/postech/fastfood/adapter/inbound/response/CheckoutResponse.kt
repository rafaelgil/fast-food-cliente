package br.com.fiap.postech.fastfood.adapter.inbound.response

import br.com.fiap.postech.fastfood.application.domain.valueObjets.FormaPagamento
import br.com.fiap.postech.fastfood.application.domain.valueObjets.StatusCheckout
import java.time.LocalDateTime
import java.util.*

data class CheckoutResponse(

    var id: UUID? = null,
    var idPedido: UUID? = null,
    var status: StatusCheckout? = null,
    var formaPagamento: FormaPagamento? = null,
    var data: LocalDateTime? = null
)
