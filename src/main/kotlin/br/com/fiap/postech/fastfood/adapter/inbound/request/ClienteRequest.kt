package br.com.fiap.postech.fastfood.adapter.inbound.request

data class ClienteRequest (

    var cpf: String? = null,
    var nome: String? = null,
    var email: String? = null
)