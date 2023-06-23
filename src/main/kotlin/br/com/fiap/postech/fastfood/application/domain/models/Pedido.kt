package br.com.fiap.postech.fastfood.application.domain.models

import br.com.fiap.postech.fastfood.application.domain.valueObjets.StatusPedido
import java.time.LocalDateTime
import java.util.*

data class Pedido(
    var id: UUID? = null,
    var clienteId: UUID? = null,
    var lancheId: UUID? = null,
    var bebidaId: UUID? = null,
    var acompanhamentoId: UUID? = null,
    var sobremesaId: UUID? = null,
    var dataPedido: LocalDateTime? = null,
    var status: StatusPedido? = null
)
