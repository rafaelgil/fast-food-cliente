package br.com.fiap.postech.fastfood.application.ports.interfaces

import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.ProdutoEntity
import br.com.fiap.postech.fastfood.application.domain.dtos.ProdutoDTO
import java.util.*

interface ProdutoServicePort {
    fun cadastrar(produto: ProdutoDTO): ProdutoEntity
    fun atualizar(id: UUID, produto: ProdutoDTO): ProdutoEntity
}