package br.com.fiap.postech.fastfood.application.ports.interfaces

import br.com.fiap.postech.fastfood.application.domain.dtos.ProdutoDTO
import java.util.*

interface ProdutoServicePort {
    fun cadastrar(produto: ProdutoDTO): ProdutoDTO
    fun atualizar(id: UUID, produto: ProdutoDTO): ProdutoDTO
}