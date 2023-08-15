package br.com.fiap.postech.fastfood.adapter.inbound.response

import br.com.fiap.postech.fastfood.domain.valueObjets.StatusPedido
import java.time.LocalDateTime
import java.util.*

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
