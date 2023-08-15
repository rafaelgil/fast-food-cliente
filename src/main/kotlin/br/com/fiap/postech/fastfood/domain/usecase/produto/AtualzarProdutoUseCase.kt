package br.com.fiap.postech.fastfood.domain.usecase.produto

import br.com.fiap.postech.fastfood.domain.entity.Produto
import br.com.fiap.postech.fastfood.domain.repository.ProdutoRepository
import java.util.*

class AtualzarProdutoUseCase(
    private val produtoRepository: ProdutoRepository
) {
    fun executa(id: UUID, produto: Produto): Produto {
        if(produtoRepository.existeProduto(id)) {
            return produtoRepository.atualizar(id, produto)
        } else {
            throw IllegalArgumentException("Produto ${id} não encontrado")
        }
    }
}