package br.com.fiap.postech.fastfood.domain.entity

import br.com.fiap.postech.fastfood.domain.valueObjets.Categoria
import br.com.fiap.postech.fastfood.domain.valueObjets.Descricao
import br.com.fiap.postech.fastfood.domain.valueObjets.Preco
import java.util.*

data class Produto (
    var id: UUID? = null,
    var descricao: Descricao,
    var categoria: Categoria,
    var preco: Preco
)