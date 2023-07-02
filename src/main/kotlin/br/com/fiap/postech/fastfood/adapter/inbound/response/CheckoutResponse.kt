package br.com.fiap.postech.fastfood.adapter.inbound.response

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime
import java.util.*

data class CheckoutResponse(
    var id: UUID?,

    @JsonProperty("id_pedido")
    var pedidoId: UUID?,

    @JsonProperty("id_pagamento")
    var pagamentoId: UUID?,
    var status: String?,
    var data: LocalDateTime?
)
