package br.com.fiap.postech.fastfood.domain.entity

import br.com.fiap.postech.fastfood.domain.valueObjets.FormaPagamento
import br.com.fiap.postech.fastfood.domain.valueObjets.StatusPagamento
import java.math.BigDecimal
import java.util.*

data class Pagamento(
    var id: UUID? = null,
    var formaPagamento: FormaPagamento? = null,
    var valor: BigDecimal? = null,
    var status: StatusPagamento? = null
)
