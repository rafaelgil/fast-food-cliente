package br.com.fiap.postech.fastfood.domain.usecase.pedido

import br.com.fiap.postech.fastfood.application.domain.exception.NotFoundEntityException
import br.com.fiap.postech.fastfood.domain.entity.ItemPedido
import br.com.fiap.postech.fastfood.domain.entity.Pedido
import br.com.fiap.postech.fastfood.domain.repository.PedidoRepository
import br.com.fiap.postech.fastfood.domain.repository.ProdutoRepository
import java.util.*

class RemoverItemPedidoUseCase(
    private val pedidoRepository: PedidoRepository,
    private val produtoRepository: ProdutoRepository,
) {
    fun executa(idPedido: UUID, itemPedido: ItemPedido): Pedido {

        val opPedido = pedidoRepository.busca(idPedido)

        if (opPedido.isEmpty) {
            throw NotFoundEntityException("Pedido ${idPedido} não encontrado")
        }

        val pedido = opPedido.get()

        validarRemoverItem(pedido, itemPedido)

        return pedidoRepository.atualizar(pedido)
    }

    private fun validarRemoverItem(pedido: Pedido, itemPedido: ItemPedido) {

        val produto = produtoRepository.buscaPorId(itemPedido.produto!!.id!!)

        if (produto == null) {
            throw NotFoundEntityException("O produto ${itemPedido?.produto?.id} não encontrado")
        }

        val itens = mutableListOf<ItemPedido>()
        itens.addAll(pedido.itens!!.toMutableList().filter { it.produto!!.id != itemPedido.produto!!.id })

        pedido.itens = itens
    }
}