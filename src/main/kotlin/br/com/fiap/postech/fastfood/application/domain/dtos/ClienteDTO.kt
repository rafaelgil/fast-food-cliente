package br.com.fiap.postech.fastfood.application.domain.dtos

import java.util.*

data class ClienteDTO (

    var cpf: String? = null,
    var nome: String? = null,
    var email: String? = null
)

data class ClienteResponseDTO (

    var id: UUID? = null,
    var cpf: String? = null,
    var nome: String? = null,
    var email: String? = null
)