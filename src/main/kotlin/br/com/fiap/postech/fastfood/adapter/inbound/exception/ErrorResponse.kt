package br.com.fiap.postech.fastfood.adapter.inbound.exception

data class ErrorResponse(
    var codigoHttp: Int,
    var mensagem: String
)