package br.com.fiap.postech.fastfood.adapter.controller

import br.com.fiap.postech.fastfood.adapter.presenter.toProduto
import br.com.fiap.postech.fastfood.adapter.presenter.toProdutoResponse
import br.com.fiap.postech.fastfood.domain.usecase.produto.AtualizarProdutoUseCase
import br.com.fiap.postech.fastfood.domain.usecase.produto.BuscarProdutoPorCategoriaUseCase
import br.com.fiap.postech.fastfood.domain.usecase.produto.CadastrarProdutoUseCase
import br.com.fiap.postech.fastfood.domain.usecase.produto.RemoverProdutoUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("produto")
class ProdutoController (
    private val cadastrarProdutoUseCase: CadastrarProdutoUseCase,
    private val atualizarProdutoUseCase: AtualizarProdutoUseCase,
    private val removerProdutoUseCase: RemoverProdutoUseCase,
    private val buscarProdutoPorCategoriaUseCase: BuscarProdutoPorCategoriaUseCase
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastrarProdutoCleanArch(@RequestBody request: br.com.fiap.postech.fastfood.adapter.presenter.ProdutoRequest): br.com.fiap.postech.fastfood.adapter.presenter.ProdutoResponse {

        return cadastrarProdutoUseCase.executa(request.toProduto()).toProdutoResponse()
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: UUID, @RequestBody request: br.com.fiap.postech.fastfood.adapter.presenter.ProdutoRequest) {
        atualizarProdutoUseCase.executa(id, request.toProduto())
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: UUID) {
        removerProdutoUseCase.executa(id)
    }

    @GetMapping("/categoria")
    fun buscarPorCategoria(@RequestParam nome: String): List<br.com.fiap.postech.fastfood.adapter.presenter.ProdutoResponse>? {
        return buscarProdutoPorCategoriaUseCase.executa(nome).map { it.toProdutoResponse() }
    }
}