package br.com.fiap.postech.fastfood.application.domain.models

import java.util.*

data class Pedido(
    var id: UUID? = null,
    var clienteId: UUID? = null,
    var lancheId: UUID? = null,
    var bebidaId: UUID? = null,
    var acompanhamentoId: UUID? = null,
    var sobremesaId: UUID? = null
)
