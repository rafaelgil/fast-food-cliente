package br.com.fiap.postech.fastfood.application.domain.models

import br.com.fiap.postech.fastfood.application.domain.valueObjets.FormaPagamento
import br.com.fiap.postech.fastfood.application.domain.valueObjets.StatusPagamento
import java.math.BigDecimal
import java.util.*

data class Pagamento(
    var id: UUID? = null,
    var formaPagamento: FormaPagamento? = null,
    var valor: BigDecimal? = null,
    var status: StatusPagamento? = null
)
