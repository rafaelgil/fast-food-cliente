package br.com.fiap.postech.fastfood.adapter.gateway.schema

import br.com.fiap.postech.fastfood.domain.entity.Pagamento
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@Entity(name = "checkout")
class CheckoutSchema (

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null,

    @OneToOne
    @JoinColumn(name = "pedido_id", referencedColumnName = "id")
    var pedido: PedidoSchema,

    @OneToOne
    @JoinColumn(name = "pedido_id", referencedColumnName = "id")
    var pagamento: PagamentoSchema,

    var data: LocalDateTime

)