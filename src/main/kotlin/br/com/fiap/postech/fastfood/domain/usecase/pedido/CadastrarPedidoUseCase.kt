package br.com.fiap.postech.fastfood.domain.usecase.pedido

import br.com.fiap.postech.fastfood.domain.entity.Pedido
import br.com.fiap.postech.fastfood.domain.entity.Produto
import br.com.fiap.postech.fastfood.domain.repository.PedidoRepository
import br.com.fiap.postech.fastfood.domain.repository.ProdutoRepository
import br.com.fiap.postech.fastfood.domain.valueObjets.StatusPedido
import java.time.LocalDateTime
import java.util.*

class CadastrarPedidoUseCase(
    private val pedidoRepository: PedidoRepository,
    private val produtoRepository: ProdutoRepository
) {

    fun executa(idLanche: UUID? = null, idBebida: UUID? = null, idSobremesa: UUID? = null, idCliente: UUID): Pedido {

        var lanche = idLanche?.let { produtoRepository.buscaPorId(it) }
        var bebida = idBebida?.let { produtoRepository.buscaPorId(it) }
        var sobremesa = idSobremesa?.let { produtoRepository.buscaPorId(it) }

        var pedido = Pedido(
            lanche = lanche,
            bebida = bebida,
            sobremesa = sobremesa,
            status = StatusPedido.EM_PREPARACAO,
            data = LocalDateTime.now()
        )

    }
}