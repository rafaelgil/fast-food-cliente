package br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities

import jakarta.persistence.*
import jakarta.persistence.CascadeType.ALL
import jakarta.persistence.CascadeType.MERGE
import java.time.LocalDateTime
import java.util.*

@Entity(name = "checkout")
data class CheckoutEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null,

    @OneToOne(cascade = arrayOf(MERGE))
    @JoinColumn(name = "pedido_id")
    var pedido: PedidoEntity,

    @Column(name = "status")
    var status: String,

    @Column(name = "data")
    var dataCheckout: LocalDateTime
)