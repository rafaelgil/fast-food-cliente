package br.com.fiap.postech.fastfood.domain.usecase.produto

import br.com.fiap.postech.fastfood.domain.entity.Produto
import br.com.fiap.postech.fastfood.domain.repository.ProdutoRespository

class CadastrarProdutoUseCase(
    private val produtoRepository: ProdutoRespository
) {

    fun executa(produto: Produto): Produto {

        produtoRepository.cadastrar(produto)

        return produto
    }
}