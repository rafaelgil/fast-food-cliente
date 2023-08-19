package br.com.fiap.postech.fastfood.domain.usecase.pedido

import br.com.fiap.postech.fastfood.application.domain.exception.NotFoundEntityException
import br.com.fiap.postech.fastfood.domain.entity.ItemPedido
import br.com.fiap.postech.fastfood.domain.entity.Pedido
import br.com.fiap.postech.fastfood.domain.entity.Produto
import br.com.fiap.postech.fastfood.domain.exception.ProdutoPrecoException
import br.com.fiap.postech.fastfood.domain.repository.PedidoRepository
import br.com.fiap.postech.fastfood.domain.repository.ProdutoRepository
import java.util.*

class AdicionarItemPedidoUseCase(
    private val pedidoRepository: PedidoRepository,
    private val produtoRepository: ProdutoRepository,
) {
    fun executa(idPedido: UUID, itemPedido: ItemPedido): Pedido {

        val opPedido = pedidoRepository.busca(idPedido)

        if (opPedido.isEmpty) {
            throw NotFoundEntityException("Pedido ${idPedido} não encontrado")
        }

        val pedido = opPedido.get()

        validarAdicionarItem(pedido, itemPedido)

        return pedidoRepository.atualizar(pedido)
    }

    private fun validarAdicionarItem(pedido: Pedido, itemPedido: ItemPedido) {

        val produto = produtoRepository.buscaPorId(itemPedido.produto!!.id!!)

        if (produto == null) {
            throw NotFoundEntityException("O produto ${itemPedido?.produto?.id} não encontrado")
        }

        if (produto?.preco?.valor != itemPedido?.preco) {
            throw ProdutoPrecoException("O produto ${itemPedido?.produto?.id} está com preço inválido")
        }

        itemPedido.produto = Produto(produto!!.id, produto!!.descricao, produto!!.categoria, produto!!.preco)

        val itens = mutableListOf<ItemPedido>()
        itens.addAll(pedido.itens!!.toMutableList())
        itens.add(itemPedido)

        pedido.itens = itens
    }
}