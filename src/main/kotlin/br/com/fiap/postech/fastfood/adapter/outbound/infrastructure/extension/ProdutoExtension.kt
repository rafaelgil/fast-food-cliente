package br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.extension

import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.ProdutoEntity
import br.com.fiap.postech.fastfood.domain.entity.Produto
import br.com.fiap.postech.fastfood.domain.valueObjets.CategoriaProduto

fun Produto.toProdutoEntity() =
    ProdutoEntity(
        id = this.id,
        descricao = this.descricao.descricao,
        categoria = CategoriaProduto.valueOf(this.categoria.categoria.uppercase()),
        preco = this.preco.valor
    )