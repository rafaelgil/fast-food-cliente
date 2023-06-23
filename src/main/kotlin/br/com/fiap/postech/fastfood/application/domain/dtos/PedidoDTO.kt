package br.com.fiap.postech.fastfood.application.domain.dtos

import java.util.*

data class PedidoDTO (
    var id: UUID?,
    var clienteId: UUID?,
    var lancheId: UUID?,
    var bebidaId: UUID?,
    var acompanhamentoId: UUID?,
    var sobremesaId: UUID?
)
