package br.com.fiap.postech.fastfood.application.domain.models

import br.com.fiap.postech.fastfood.application.domain.valueObjets.*
import java.util.UUID

data class Produto (
    var id: UUID? = null,
    var descricao: Descricao,
    var categoria: Categoria,
    var preco: Preco
)