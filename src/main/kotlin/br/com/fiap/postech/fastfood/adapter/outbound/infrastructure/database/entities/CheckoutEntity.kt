package br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities

import br.com.fiap.postech.fastfood.application.domain.models.Pedido
import jakarta.persistence.*
import jakarta.persistence.CascadeType.ALL
import java.util.*

@Entity(name = "checkout")
data class CheckoutEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null,

    @OneToOne(cascade = arrayOf(ALL))
    @JoinColumn(name = "pedido_id", referencedColumnName = "id")
    var pedido: Pedido,

    @Column(name = "status")
    var status: String
)