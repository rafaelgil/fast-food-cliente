package br.com.fiap.postech.fastfood.domain.usecase.pedido

import br.com.fiap.postech.fastfood.application.domain.exception.NotFoundEntityException
import br.com.fiap.postech.fastfood.domain.entity.Pedido
import br.com.fiap.postech.fastfood.domain.entity.Produto
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
        validarAtualizarCliente(pedido)

        validarAtualizarProduto(pedido)

        return pedidoRepository.cadastrar(pedido)
    }

    private fun validarAtualizarProduto(pedido: Pedido) {
        pedido.itens.apply {
            this.forEach {
                val produto = produtoRepository.buscaPorId(it.produto.id!!)

                if(produto == null){
                    throw NotFoundEntityException("O produto ${it.produto.id} não encontrado")
                }

                if(produto.preco?.valor != it.preco){
                    throw ProdutoPrecoException("O produto ${it.produto.id} está com preço diferente do catálogo")
                }

                it.produto = Produto(produto.id, produto.descricao, produto.categoria, produto.preco)
            }
        }
    }

    private fun validarAtualizarCliente(pedido: Pedido) {
        val cliente = clienteRepository.buscarPorId(pedido.cliente.id!!)
        if (cliente == null) {
            throw ClienteNotFoundException("Cliente ${pedido.cliente.id} não encontrado")
        }
        pedido.cliente = cliente
    }

}