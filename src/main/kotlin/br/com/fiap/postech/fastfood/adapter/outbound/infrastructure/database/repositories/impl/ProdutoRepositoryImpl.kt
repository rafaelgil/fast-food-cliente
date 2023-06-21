package br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.repositories.impl

import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.ClienteEntity
import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.ProdutoEntity
import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.repositories.ClienteRepositorySpring
import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.repositories.ProdutoRepositorySpring
import br.com.fiap.postech.fastfood.application.domain.extension.toClienteEntity
import br.com.fiap.postech.fastfood.application.domain.extension.toProdutoEntity
import br.com.fiap.postech.fastfood.application.domain.models.Cliente
import br.com.fiap.postech.fastfood.application.domain.models.Produto
import br.com.fiap.postech.fastfood.application.ports.repositories.ClienteRepositoryPort
import br.com.fiap.postech.fastfood.application.ports.repositories.ProdutoRepositoryPort
import org.springframework.stereotype.Component
import java.util.*

@Component
class ProdutoRepositoryImpl(
    private val produtoRepositorySpring: ProdutoRepositorySpring
): ProdutoRepositoryPort {
    override fun cadastrar(produto: Produto) =
        produtoRepositorySpring.save(produto.toProdutoEntity())
    override fun procurarPorId(id: UUID) =
        produtoRepositorySpring.findById(id)

    override fun atulizar(produto: Produto) =
        produtoRepositorySpring.save(produto.toProdutoEntity())
}