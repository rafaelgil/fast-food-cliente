package br.com.fiap.postech.fastfood.domain.entity

import br.com.fiap.postech.fastfood.domain.valueObjets.StatusPagamento
import java.util.*

data class Pagamento(
    var id: UUID,
    var status: StatusPagamento,
)


