package br.com.fiap.postech.fastfood.application.domain.extension

import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.ClienteEntity
import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.ProdutoEntity
import br.com.fiap.postech.fastfood.application.domain.dtos.ClienteDTO
import br.com.fiap.postech.fastfood.application.domain.dtos.ProdutoDTO
import br.com.fiap.postech.fastfood.application.domain.models.Cliente
import br.com.fiap.postech.fastfood.application.domain.models.Produto
import br.com.fiap.postech.fastfood.application.domain.valueObjets.*
import java.util.UUID

fun ProdutoDTO.toProdutoModel(id: UUID? = null) =
    Produto(
        id = id,
        descricao = Descricao(this.descricao),
        categoria = Categoria(this.categoria),
        preco = Preco(this.preco)
    )

fun Produto.toProdutoEntity() =
    ProdutoEntity(
        id = this.id,
        descricao = this.descricao.descricao,
        categoria = CategoriaProduto.valueOf(this.categoria.categoria.uppercase()),
        preco = this.preco.valor
    )
fun ProdutoEntity.toProdutoDTO() =
    ProdutoDTO(
        id = this.id,
        descricao = this.descricao,
        categoria = this.categoria.name,
        preco = this.preco
    )

fun Produto.toProdutoDTO(): ProdutoDTO {
    return ProdutoDTO(
        id = this.id,
        descricao = this.descricao.descricao,
        categoria = this.categoria.categoria,
        preco = this.preco.valor
    )
}

fun ProdutoEntity.toProdutoModel(): Produto {
    return Produto(
        id = this.id,
        descricao = Descricao(this.descricao),
        categoria = Categoria(this.categoria.name),
        preco = Preco(this.preco)
    )
}

fun ProdutoDTO.toProdutoEntity(): ProdutoEntity {
    return ProdutoEntity(
        id = this.id,
        descricao = this.descricao,
        categoria = CategoriaProduto.valueOf(this.categoria.uppercase()),
        preco = this.preco
    )
}