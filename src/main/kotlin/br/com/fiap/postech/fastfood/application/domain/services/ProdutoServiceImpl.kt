package br.com.fiap.postech.fastfood.application.domain.services

import br.com.fiap.postech.fastfood.application.domain.dtos.ProdutoDTO
import br.com.fiap.postech.fastfood.application.domain.exception.NotFoundEntityException
import br.com.fiap.postech.fastfood.application.domain.extension.toProdutoDTO
import br.com.fiap.postech.fastfood.application.domain.extension.toProdutoModel
import br.com.fiap.postech.fastfood.application.domain.valueObjets.Categoria
import br.com.fiap.postech.fastfood.application.domain.valueObjets.CategoriaProduto
import br.com.fiap.postech.fastfood.application.ports.interfaces.ProdutoServicePort
import br.com.fiap.postech.fastfood.application.ports.repositories.ProdutoRepositoryPort
import java.util.*

class ProdutoServiceImpl(
    private val produtoRepositoryPort: ProdutoRepositoryPort
): ProdutoServicePort {
    override fun cadastrar(produtoDTO: ProdutoDTO) =
        produtoRepositoryPort.cadastrar(produtoDTO.toProdutoModel()).toProdutoDTO()
    override fun atualizar(id: UUID, produtoDTO: ProdutoDTO) =
        if(produtoRepositoryPort.existeProduto(id))
            produtoRepositoryPort.atualizar(produtoDTO.toProdutoModel(id))
                .toProdutoDTO()
        else {
            throw NotFoundEntityException("Produto ${id} não encontrado")
        }
    override fun remover(id: UUID) {
        if(produtoRepositoryPort.existeProduto(id))
            produtoRepositoryPort.remover(id)
        else {
            throw NotFoundEntityException("Produto ${id} não encontrado")
        }
    }

    override fun buscarPorCategoria(categoria: String): List<ProdutoDTO>? {
        val categoria = CategoriaProduto.valueOf(Categoria(categoria).categoria.toUpperCase())
        return produtoRepositoryPort.buscarPorCategoria(categoria)?.map { it.toProdutoDTO() }
    }
}