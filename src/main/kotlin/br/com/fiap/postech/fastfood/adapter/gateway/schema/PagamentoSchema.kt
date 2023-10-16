package br.com.fiap.postech.fastfood.adapter.gateway.schema

import br.com.fiap.postech.fastfood.domain.valueObjets.FormaPagamento
import br.com.fiap.postech.fastfood.domain.valueObjets.StatusPagamento
import jakarta.persistence.*
import java.math.BigDecimal
import java.util.*

@Entity(name = "pagamento")
class PagamentoSchema (

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null,

    @Column
    @Enumerated(EnumType.STRING)
    var formaPagamento: FormaPagamento,

    @Column
    var valor: BigDecimal,

    @Column
    @Enumerated(EnumType.STRING)
    var status: StatusPagamento,

    @Column(name = "qrcode_id")
    var qrCodeId:  UUID? = null,

    @Column(name = "qrcode")
    var qrCode: String? = null,
)