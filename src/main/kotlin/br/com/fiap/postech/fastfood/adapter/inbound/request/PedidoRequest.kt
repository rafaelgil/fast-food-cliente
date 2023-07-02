package br.com.fiap.postech.fastfood.adapter.inbound.request

import com.fasterxml.jackson.annotation.JsonProperty
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
