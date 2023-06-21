package br.com.fiap.postech.fastfood.application.domain.dtos

import java.math.BigDecimal
import java.util.UUID

data class ProdutoDTO (
    var id: UUID? = null,
    var descricao: String,
    var categoria: String,
    var preco: BigDecimal
) {
    constructor(descricao: String,
                categoria: String,
                preco: BigDecimal) : this(null, descricao, categoria, preco) {
    }

}