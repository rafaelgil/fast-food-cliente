package br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.repositories.impl

import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.repositories.ProdutoRepositorySpring
import br.com.fiap.postech.fastfood.application.domain.extension.toProdutoEntity
import br.com.fiap.postech.fastfood.application.domain.models.Produto
import br.com.fiap.postech.fastfood.application.ports.repositories.ProdutoRepositoryPort
import org.springframework.stereotype.Component
import java.util.*

@Component
class ProdutoRepositoryImpl(
    private val produtoRepositorySpring: ProdutoRepositorySpring
): ProdutoRepositoryPort {
    override fun cadastrar(produto: Produto) =
        produtoRepositorySpring.save(produto.toProdutoEntity())
    override fun existeProduto(id: UUID) =
        produtoRepositorySpring.existsById(id)

    override fun atualizar(produto: Produto) =
        produtoRepositorySpring.save(produto.toProdutoEntity())
}