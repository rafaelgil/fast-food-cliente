package br.com.fiap.postech.fastfood.domain.usecase.produto

import br.com.fiap.postech.fastfood.domain.repository.ProdutoRespository
import java.util.*

class RemoverProdutoUseCase(
    private val produtoRepository: ProdutoRespository
) {
    fun executa(id: UUID) {
        if(produtoRepository.existeProduto(id))
            produtoRepository.atualizar(id)
        else {
            throw IllegalArgumentException("Produto ${id} não encontrado")
        }
    }
}