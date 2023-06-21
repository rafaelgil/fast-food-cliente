package br.com.fiap.postech.fastfood.application.domain.services

import br.com.fiap.postech.fastfood.application.domain.dtos.ProdutoDTO
import br.com.fiap.postech.fastfood.application.domain.extension.toProdutoDTO
import br.com.fiap.postech.fastfood.application.domain.extension.toProdutoModel
import br.com.fiap.postech.fastfood.application.ports.interfaces.ProdutoServicePort
import br.com.fiap.postech.fastfood.application.ports.repositories.ProdutoRepositoryPort
import java.lang.RuntimeException
import java.util.*

class ProdutoServiceImpl(
    private val produtoRepositoryPort: ProdutoRepositoryPort
): ProdutoServicePort {
    override fun cadastrar(produtoDTO: ProdutoDTO) =
        produtoRepositoryPort.cadastrar(produtoDTO.toProdutoModel()).toProdutoDTO()
    override fun atualizar(id: UUID, produtoDTO: ProdutoDTO) =
        produtoRepositoryPort.atualizar(produtoDTO.toProdutoModel(id))
            .toProdutoDTO().takeIf { produtoRepositoryPort.existeProduto(id) }
        ?: run {
            throw RuntimeException("Produto ${id} não encontrado")
        }
}