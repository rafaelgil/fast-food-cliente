package br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities

import jakarta.persistence.*
import java.math.BigDecimal
import java.util.*

@Entity(name = "pagamento")
data class PagamentoEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null,

    @Column(name = "forma_pagamento")
    var formaPagamento: String? = null,

    @Column
    var valor: BigDecimal? = null,

    @Column
    var status: String? = null
)
