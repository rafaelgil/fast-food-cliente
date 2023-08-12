package br.com.fiap.postech.fastfood.domain.usecase.produto

import br.com.fiap.postech.fastfood.domain.entity.Produto
import br.com.fiap.postech.fastfood.domain.repository.ProdutoRespository
import br.com.fiap.postech.fastfood.domain.valueObjets.Categoria
import br.com.fiap.postech.fastfood.domain.valueObjets.CategoriaProduto
import java.util.*

class BuscarProdutoPorCategoriaUseCase(
    private val produtoRepository: ProdutoRespository
) {

    fun executa(categoria: String): List<Produto> {
        val categoria = CategoriaProduto.valueOf(Categoria(categoria).categoria.toUpperCase())
        return produtoRepository.buscarPorCategoria(categoria)
    }
}