package br.com.fiap.postech.fastfood.cliente.domain.exception

class ClienteNotFoundException(s: String, exception: Exception?): Exception(s, exception)
{
    constructor(s: String) : this(s, null)
}