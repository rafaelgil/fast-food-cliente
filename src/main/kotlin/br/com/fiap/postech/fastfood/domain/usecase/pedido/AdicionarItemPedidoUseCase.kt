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

        val pedido = pedidoRepository.buscarPorId(idPedido)
            ?: throw NotFoundEntityException("Pedido ${idPedido} não encontrado")

        validarAdicionarItem(pedido, itemPedido)

        return pedidoRepository.atualizar(pedido)
    }

    private fun validarAdicionarItem(pedido: Pedido, itemPedido: ItemPedido) {

        val produto = produtoRepository.buscaPorId(itemPedido.produto.id!!)
            ?: throw NotFoundEntityException("O produto ${itemPedido.produto.id} não encontrado")

        produto.preco?.valor.takeIf { valor -> valor == itemPedido.preco }.apply {
            itemPedido.produto = Produto(produto.id, produto.descricao, produto.categoria, produto.preco)
        }?: run {
            throw ProdutoPrecoException("O produto ${itemPedido.produto.id} está com preço inválido")
        }

        val itens = mutableListOf<ItemPedido>()
        itens.addAll(pedido.itens.toMutableList())
        itens.add(itemPedido)

        pedido.itens = itens
    }
}