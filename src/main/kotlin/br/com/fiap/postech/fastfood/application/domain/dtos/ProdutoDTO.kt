package br.com.fiap.postech.fastfood.application.domain.dtos

import java.math.BigDecimal

data class ProdutoDTO (
    var descricao: String,
    var categoria: String,
    var preco: BigDecimal
)