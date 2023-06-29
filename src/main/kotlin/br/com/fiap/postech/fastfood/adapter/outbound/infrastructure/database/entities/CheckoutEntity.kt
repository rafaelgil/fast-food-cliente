package br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities

import br.com.fiap.postech.fastfood.application.domain.valueObjets.FormaPagamento
import br.com.fiap.postech.fastfood.application.domain.valueObjets.StatusCheckout
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
    var pedido: PedidoEntity? = null,

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    var status: StatusCheckout? = null,

    @Enumerated(EnumType.STRING)
    @Column(name = "forma_pagamento")
    var formaPagamento: FormaPagamento? = null,

    @Column(name = "data")
    var dataCheckout: LocalDateTime? = null
)