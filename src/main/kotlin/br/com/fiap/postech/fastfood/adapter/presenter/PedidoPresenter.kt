package br.com.fiap.postech.fastfood.adapter.presenter

import br.com.fiap.postech.fastfood.adapter.gateway.schema.PedidoSchema
import br.com.fiap.postech.fastfood.adapter.inbound.response.ClienteResponse
//import br.com.fiap.postech.fastfood.adapter.inbound.response.PedidoResponse
//import br.com.fiap.postech.fastfood.adapter.inbound.response.ProdutoResponse
import br.com.fiap.postech.fastfood.domain.entity.Pedido
import br.com.fiap.postech.fastfood.domain.valueObjets.StatusPedido
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime
import java.util.*

data class PedidoRequest(
    @JsonProperty("id")
    var id: UUID? = null,

    @JsonProperty("id_cliente")
    var clienteId: UUID? = null,

    @JsonProperty("id_lanche")
    var lancheId: UUID? = null,

    @JsonProperty("id_bebida")
    var bebidaId: UUID? = null,

    @JsonProperty("id_acompanhamento")
    var acompanhamentoId: UUID? = null,

    @JsonProperty("id_sobremesa")
    var sobremesaId: UUID? = null
)

data class PedidoResponse(
    var id: UUID? = null,
    var cliente: ClienteResponse? = null,
    var lanche: ProdutoResponse? = null,
    var bebida: ProdutoResponse? = null,
    var acompanhamento: ProdutoResponse? = null,
    var sobremesa: ProdutoResponse? = null,
    var data: LocalDateTime? = null,
    var status: StatusPedido? = null,
)

fun Pedido.toPedidoResponse(): PedidoResponse {
    return PedidoResponse(
        id = this.id,
        lanche = this.lanche?.toProdutoResponse(),
        bebida = this.bebida?.toProdutoResponse(),
        sobremesa = this.sobremesa?.toProdutoResponse(),
        data = this.data,
        status = this.status
    )
}

fun PedidoSchema.toPedido(): Pedido {
    return Pedido(
        id = this.id,
        data = this.data,
        status = this.status,
        lanche = this.lanche?.toProduto(),
        bebida = this.bebida?.toProduto(),
        sobremesa = this.sobremesa?.toProduto()
    )
}
