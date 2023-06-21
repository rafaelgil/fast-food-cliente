package br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities

import jakarta.persistence.*
import java.math.BigDecimal
import java.util.*

@Entity(name = "produto")
data class ProdutoEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID? = null,

    @Column
    var descricao: String,

    @Column
    var categoria: String,

    @Column
    var preco: BigDecimal
)