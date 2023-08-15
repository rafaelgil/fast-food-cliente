package br.com.fiap.postech.fastfood.domain.usecase.produto

import br.com.fiap.postech.fastfood.domain.entity.Produto
import br.com.fiap.postech.fastfood.domain.repository.ProdutoRepository

class CadastrarProdutoUseCase(
    private val produtoRepository: ProdutoRepository
) {

    fun executa(produto: Produto): Produto {

        return produtoRepository.cadastrar(produto)
    }
}