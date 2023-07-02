package br.com.fiap.postech.fastfood.adapter.inbound.request

import br.com.fiap.postech.fastfood.adapter.inbound.response.ClienteResponse
import br.com.fiap.postech.fastfood.adapter.inbound.response.ProdutoResponse

data class PedidoRequest(
    var cliente: ClienteResponse? = null,
    var lanche: ProdutoResponse? = null,
    var bebida: ProdutoResponse? = null,
    var acompanhamento: ProdutoResponse? = null,
    var sobremesa: ProdutoResponse? = null,
)
