package br.com.fiap.postech.fastfood.adapter.inbound

import br.com.fiap.postech.fastfood.application.domain.dtos.ProdutoDTO
import br.com.fiap.postech.fastfood.application.ports.interfaces.ProdutoServicePort
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("produto")
class ProdutoController (
    private val produtoServicePort: ProdutoServicePort
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastrarProduto(@RequestBody produto: ProdutoDTO) {
        produtoServicePort.cadastrar(produto)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: UUID, @RequestBody produto: ProdutoDTO) {
        produtoServicePort.atualizar(id, produto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: UUID) {
        produtoServicePort.remover(id)
    }
}