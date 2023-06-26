package br.com.fiap.postech.fastfood.application.domain.dtos

import br.com.fiap.postech.fastfood.application.domain.valueObjets.StatusPedido
import java.time.LocalDateTime
import java.util.*

data class PedidoDTO (
    var id: UUID?,
    var lanche: ProdutoDTO?,
    var bebida: ProdutoDTO?,
    var acompanhamento: ProdutoDTO?,
    var sobremesa: ProdutoDTO?,
    var dataPedido: LocalDateTime?,
    var status: StatusPedido?,
    var cliente: ClienteDTO?
)
