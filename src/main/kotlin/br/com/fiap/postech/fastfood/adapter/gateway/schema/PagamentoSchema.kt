package br.com.fiap.postech.fastfood.adapter.gateway.schema

import br.com.fiap.postech.fastfood.domain.valueObjets.StatusPagamento
import jakarta.persistence.*
import java.util.*

@Entity(name = "pagamento")
class PagamentoSchema (

    @Id
    var id: UUID,

    @Column
    @Enumerated(EnumType.STRING)
    var status: StatusPagamento
)