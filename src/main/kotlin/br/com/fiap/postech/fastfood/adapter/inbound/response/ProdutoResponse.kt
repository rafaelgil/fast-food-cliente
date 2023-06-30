package br.com.fiap.postech.fastfood.adapter.inbound.response

import java.math.BigDecimal
import java.util.*

class ProdutoResponse(
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