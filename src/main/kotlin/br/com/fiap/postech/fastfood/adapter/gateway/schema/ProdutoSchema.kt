package br.com.fiap.postech.fastfood.adapter.gateway.schema

import br.com.fiap.postech.fastfood.domain.valueObjets.CategoriaProduto
import jakarta.persistence.*
import java.math.BigDecimal
import java.util.*

@Entity(name = "produto")
data class ProdutoSchema (

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID? = null,

    @Column
    var descricao: String,

    @Column
    @Enumerated( value = EnumType.STRING)
    var categoria: CategoriaProduto,

    @Column
    var preco: BigDecimal
)