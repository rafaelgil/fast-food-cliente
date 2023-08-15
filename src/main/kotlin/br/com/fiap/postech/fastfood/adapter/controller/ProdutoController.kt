package br.com.fiap.postech.fastfood.adapter.controller

import br.com.fiap.postech.fastfood.adapter.inbound.extension.toProdutoDTO
import br.com.fiap.postech.fastfood.adapter.inbound.extension.toProdutoResponse
import br.com.fiap.postech.fastfood.adapter.inbound.request.ProdutoRequest
import br.com.fiap.postech.fastfood.adapter.inbound.response.ProdutoResponse
import br.com.fiap.postech.fastfood.adapter.presenter.toProduto
import br.com.fiap.postech.fastfood.adapter.presenter.toProdutoResponse
import br.com.fiap.postech.fastfood.application.domain.dtos.ProdutoDTO
import br.com.fiap.postech.fastfood.application.ports.interfaces.ProdutoServicePort
import br.com.fiap.postech.fastfood.domain.usecase.produto.AtualzarProdutoUseCase
import br.com.fiap.postech.fastfood.domain.usecase.produto.BuscarProdutoPorCategoriaUseCase
import br.com.fiap.postech.fastfood.domain.usecase.produto.CadastrarProdutoUseCase
import br.com.fiap.postech.fastfood.domain.usecase.produto.RemoverProdutoUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("produto")
class ProdutoController (
    private val cadastrarProdutoUseCase: CadastrarProdutoUseCase,
    private val atualzarProdutoUseCase: AtualzarProdutoUseCase,
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
        atualzarProdutoUseCase.executa(id, request.toProduto())
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: UUID) {
        removerProdutoUseCase.executa(id)
    }

    @GetMapping("/categoria")
    fun buscarPorCategoria(@RequestParam nome: String): List<br.com.fiap.postech.fastfood.adapter.presenter.ProdutoResponse>? {
        return buscarProdutoPorCategoriaUseCase.executa(nome)?.map { it.toProdutoResponse() }
    }
}