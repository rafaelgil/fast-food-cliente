package br.com.fiap.postech.fastfood.application.domain.models

import br.com.fiap.postech.fastfood.application.domain.valueObjets.StatusPedido
import java.time.LocalDateTime
import java.util.*

data class Pedido(
    var id: UUID? = null,
    var cliente: Cliente? = null,
    var lanche: Produto? = null,
    var bebida: Produto? = null,
    var acompanhamento: Produto? = null,
    var sobremesa: Produto? = null,
    var data: LocalDateTime? = null,
    var status: StatusPedido? = null,
)
