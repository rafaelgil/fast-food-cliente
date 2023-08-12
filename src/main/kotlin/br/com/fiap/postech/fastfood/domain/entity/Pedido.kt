package br.com.fiap.postech.fastfood.domain.entity

import br.com.fiap.postech.fastfood.domain.valueObjets.StatusPedido
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
    var clienteId: UUID? = null,
    var lancheId: UUID? = null,
    var bebidaId: UUID? = null,
    var acompanhamentoId: UUID? = null,
    var sobremesaId: UUID? = null,
)
