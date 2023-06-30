package br.com.fiap.postech.fastfood.adapter.inbound.request

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*


data class CheckoutRequest (

    @JsonProperty("id_pedido")
    var idPedido: UUID? = null,

    @JsonProperty("forma_pagamento")
    var formaPagamento: String? = null
)