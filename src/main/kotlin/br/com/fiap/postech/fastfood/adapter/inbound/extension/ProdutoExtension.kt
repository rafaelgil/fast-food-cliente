package br.com.fiap.postech.fastfood.adapter.inbound.extension

import br.com.fiap.postech.fastfood.adapter.inbound.request.ProdutoRequest
import br.com.fiap.postech.fastfood.adapter.inbound.response.ProdutoResponse
import br.com.fiap.postech.fastfood.application.domain.dtos.ProdutoDTO

fun ProdutoDTO.toProdutoResponse(): ProdutoResponse {
    return ProdutoResponse(
            id = this.id,
            descricao = this.descricao,
            categoria = this.categoria,
            preco = this.preco
    )
}

fun ProdutoRequest.toProdutoDTO(): ProdutoDTO {
    return ProdutoDTO(
            id = this.id,
            descricao = this.descricao,
            categoria = this.categoria,
            preco = this.preco
    )
}