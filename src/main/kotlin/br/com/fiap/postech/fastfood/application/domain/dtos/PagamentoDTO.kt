package br.com.fiap.postech.fastfood.application.domain.dtos

import java.math.BigDecimal
import java.util.*

data class PagamentoDTO(
    var id: UUID? = null,
    var formaPagamento: String? = null,
    var valor: BigDecimal? = null,
    var status: String? = null
)
