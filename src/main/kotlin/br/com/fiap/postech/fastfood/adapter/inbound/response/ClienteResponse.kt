package br.com.fiap.postech.fastfood.adapter.inbound.response

import java.util.*

data class ClienteResponse (

    var id: UUID? = null,
    var cpf: String? = null,
    var nome: String? = null,
    var email: String? = null
)