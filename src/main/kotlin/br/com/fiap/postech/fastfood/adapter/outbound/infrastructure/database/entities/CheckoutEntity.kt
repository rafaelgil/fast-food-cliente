package br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities

import br.com.fiap.postech.fastfood.application.domain.valueObjets.FormaPagamento
import br.com.fiap.postech.fastfood.application.domain.valueObjets.StatusCheckout
import jakarta.persistence.*
import jakarta.persistence.CascadeType.*
import java.time.LocalDateTime
import java.util.*

@Entity(name = "checkout")
data class CheckoutEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null,

    @OneToOne(cascade = [MERGE, REFRESH])
    @JoinColumn(name = "pedido_id", referencedColumnName = "id")
    var pedido: PedidoEntity? = null,

    @OneToOne(cascade = [MERGE])
    @JoinColumn(name = "id_pagamento", referencedColumnName = "id")
    var pagamento: PagamentoEntity? = null,

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    var status: StatusCheckout? = null,

    @Column(name = "data")
    var dataCheckout: LocalDateTime? = null
)