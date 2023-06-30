package br.com.fiap.postech.fastfood.application.domain.dtos

import br.com.fiap.postech.fastfood.application.domain.valueObjets.FormaPagamento
import br.com.fiap.postech.fastfood.application.domain.valueObjets.StatusCheckout
import com.fasterxml.jackson.annotation.JsonProperty
import org.apache.tomcat.util.buf.UDecoder
import java.time.LocalDateTime
import java.util.*

data class CheckoutDTO(

    var id: UUID? = null,
    var idPedido: UUID? = null,
    var status: StatusCheckout? = null,
    var formaPagamento: FormaPagamento? = null,
    var data: LocalDateTime? = null
)

data class CheckoutRequest (

    @JsonProperty("id_pedido")
    var idPedido: UUID? = null,

    @JsonProperty("forma_pagamento")
    var formaPagamento: String? = null
)
