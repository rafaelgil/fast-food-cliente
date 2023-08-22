package br.com.fiap.postech.fastfood.domain.usecase.pedido

import br.com.fiap.postech.fastfood.application.domain.exception.NotFoundEntityException
import br.com.fiap.postech.fastfood.domain.entity.Pedido
import br.com.fiap.postech.fastfood.domain.exception.ClienteNotFoundException
import br.com.fiap.postech.fastfood.domain.exception.ProdutoPrecoException
import br.com.fiap.postech.fastfood.domain.repository.ClienteRepository
import br.com.fiap.postech.fastfood.domain.repository.PedidoRepository
import br.com.fiap.postech.fastfood.domain.repository.ProdutoRepository

class CadastrarPedidoUseCase(
    private val pedidoRepository: PedidoRepository,
    private val produtoRepository: ProdutoRepository,
    private val clienteRepository: ClienteRepository
) {
    fun executa(pedido: Pedido):Pedido {
        validarCliente(pedido)

        validarItemProduto(pedido)

        return pedidoRepository.cadastrar(pedido)
    }

    private fun validarItemProduto(pedido: Pedido) {
        pedido.itens.apply {
            this.forEach {
                val produto = produtoRepository.buscaPorId(it.produto.id!!)
                    ?: throw NotFoundEntityException("O produto ${it.produto.id} não encontrado")

                produto.preco?.valor.takeIf { valor -> valor == it.preco }.apply {
                    it.produto = produto
                }?: run {
                    throw ProdutoPrecoException("O produto ${it.produto.id} está com preço diferente do catálogo")
                }
            }
        }
    }

    private fun validarCliente( pedido: Pedido ) {
        val cliente = clienteRepository.buscarPorId(pedido.cliente.id!!)
            ?: throw ClienteNotFoundException("Cliente ${pedido.cliente.id} não encontrado")

        pedido.cliente = cliente
    }

}