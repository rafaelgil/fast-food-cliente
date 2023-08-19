package br.com.fiap.postech.fastfood.domain.entity

import br.com.fiap.postech.fastfood.domain.valueObjets.StatusPedido
import java.time.LocalDateTime
import java.util.*

data class Pedido(
    var id: UUID? = null,
    var cliente: Cliente? = null,
    var produtos: List<Produto>? = null,
    var data: LocalDateTime? = null,
    var status: StatusPedido? = null,
)

