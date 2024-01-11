package br.com.fiap.postech.fastfood.adapter.presenter

import br.com.fiap.postech.fastfood.adapter.gateway.schema.ClienteSchema
import br.com.fiap.postech.fastfood.adapter.gateway.schema.ItemPedidoSchema
import br.com.fiap.postech.fastfood.adapter.gateway.schema.PedidoSchema
import br.com.fiap.postech.fastfood.domain.entity.Cliente
import br.com.fiap.postech.fastfood.domain.entity.ItemPedido
import br.com.fiap.postech.fastfood.domain.entity.Pedido
import br.com.fiap.postech.fastfood.domain.entity.Produto
import br.com.fiap.postech.fastfood.domain.valueObjets.StatusPedido
import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

data class PedidoRequest(
    @JsonProperty("id")
    var id: UUID? = null,
    @JsonProperty("id_cliente")
    var clienteId: UUID? = null,
    @JsonProperty("itens")
    var itens: List<ItemPedidoRequest>? = mutableListOf(),
)

data class PedidoResponse(
    @JsonProperty("id")
    var id: UUID? = null,
    var cliente: ClienteResponse,
    var status: String,
    @JsonProperty("itens")
    var itens: List<ItemPedidoResponse>? = mutableListOf(),
    @JsonProperty("valor_total")
    var valorTotal: BigDecimal? = BigDecimal.ZERO,
    var pagamentoId: UUID? = null
)

data class StatusPedidoResponse(
    @JsonProperty("id")
    var id: UUID? = null,
    var nomeCliente: String,
    var dataCriacao: LocalDateTime,
    var dataRecebimento: LocalDateTime?,
    var status: String,
    var itens: List<ItemPedidoSimpleResponse> = mutableListOf(),
)


data class ItemPedidoRequest(
    @JsonProperty("id_produto")
    var produtoId: UUID,
    var quantidade: Int,
    var preco: BigDecimal
)

data class ItemPedidoResponse(
    @JsonProperty("id")
    var id: UUID,
    @JsonProperty("id_produto")
    var produtoId: UUID,
    @JsonProperty("descricao_produto")
    var descricaoProduto:String,
    @JsonProperty("categoria_produto")
    var categoriaProduto:String,
    var preco: BigDecimal,
    var quantidade: Int
)

data class ItemPedidoSimpleResponse(
    @JsonProperty("descricao_produto")
    var descricaoProduto:String,
    @JsonProperty("categoria_produto")
    var categoriaProduto:String,
    var preco: BigDecimal,
    var quantidade: Int
)

fun PedidoRequest.toPedido(): Pedido {
    return Pedido(
        id = UUID.randomUUID(),
        cliente = Cliente(this.clienteId),
        data = LocalDateTime.now(),
        status = StatusPedido.AGUARDANDO_PAGAMENTO
    ).apply {
        itens = this@toPedido.itens!!.map { it.toItem() }
    }
}

fun ItemPedidoRequest.toItem() =
    ItemPedido(
        id = null,
        produto = Produto(id = this.produtoId),
        quantidade = this.quantidade,
        preco = this.preco
    )

fun Pedido.toResponse() =
    PedidoResponse(
        id = this.id,
        cliente = this.cliente.toClienteResponse(),
        status = this.status.status,
        valorTotal = valorTotal(),
        pagamentoId = pagamentoId
    ).apply {
        itens = this@toResponse.itens.map { it.toResponse() }
    }

fun Pedido.toStatusResponse() =
    StatusPedidoResponse(
        id = this.id,
        nomeCliente = this.cliente.nome!!.nome,
        dataCriacao = this.data,
        status = this.status.status,
        dataRecebimento = this.dataRecebimento
    ).apply {
        itens = this@toStatusResponse.itens.map { it.toSimpleResponse() }
    }

fun ItemPedido.toResponse(): ItemPedidoResponse {
    val produto = this.produto.toProdutoResponse()

    return ItemPedidoResponse(
        id = this.id!!,
        produtoId = produto.id,
        descricaoProduto = produto.descricao,
        categoriaProduto = produto.categoria,
        preco = this.preco,
        quantidade = this.quantidade
    )
}

fun ItemPedido.toSimpleResponse(): ItemPedidoSimpleResponse {
    val produto = this.produto.toProdutoResponse()

    return ItemPedidoSimpleResponse(
        descricaoProduto = produto.descricao,
        categoriaProduto = produto.categoria,
        preco = this.preco,
        quantidade = this.quantidade
    )
}

fun Pedido.toPedidoSchema() =
    PedidoSchema(
        id = this.id,
        data = this.data,
        cliente = ClienteSchema(this.cliente.id, this.cliente.cpf!!.cpf, this.cliente.nome!!.nome, this.cliente.email!!.email),
        status = this.status,
        dataRecebimento = this.dataRecebimento,
        pagamentoId = this.pagamentoId
    ).apply {
        itens = this@toPedidoSchema.itens.map { it.toItemPedidoSchema(this) }
    }

fun ItemPedido.toItemPedidoSchema(pedidoSchema: PedidoSchema) =
    ItemPedidoSchema(
        id = this.id,
        pedido = pedidoSchema,
        produto = this.produto.toProdutoSchema(this.produto.id),
        preco = this.preco,
        quantidade = this.quantidade
    )

fun PedidoSchema.toPedido() =
    Pedido(
        id = this.id,
        data = this.data,
        status = this.status,
        cliente = this.cliente.toCliente(),
        dataRecebimento = this.dataRecebimento,
        pagamentoId = this.pagamentoId
    ).apply {
        itens = this@toPedido.itens.map { it.toItemPedido() }
    }

fun ItemPedidoSchema.toItemPedido() =
    ItemPedido(
        id = this.id,
        produto = this.produto.toProduto(),
        quantidade = this.quantidade,
        preco = this.preco
    )