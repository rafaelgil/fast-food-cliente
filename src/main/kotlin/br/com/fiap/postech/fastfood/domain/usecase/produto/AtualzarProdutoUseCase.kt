package br.com.fiap.postech.fastfood.domain.usecase.produto

import br.com.fiap.postech.fastfood.domain.entity.Produto
import br.com.fiap.postech.fastfood.domain.repository.ProdutoRespository
import java.util.*

class AtualzarProdutoUseCase(
    private val produtoRepository: ProdutoRespository
) {
    fun executa(id: UUID, produto: Produto): Produto {
        if(produtoRepository.existeProduto(id))
            return produtoRepository.atualizar(produto)
        else {
            throw IllegalArgumentException("Produto ${id} não encontrado")
        }
    }
}