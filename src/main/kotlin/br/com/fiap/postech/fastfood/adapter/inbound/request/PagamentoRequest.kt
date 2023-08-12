package br.com.fiap.postech.fastfood.adapter.inbound.request

import br.com.fiap.postech.fastfood.domain.valueObjets.FormaPagamento
import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal

data class PagamentoRequest(
    var valor: BigDecimal? = null,

    @JsonProperty("forma_pagamento")
    var formaPagamento: String? = null
)
