package br.com.fiap.postech.fastfood.domain.exception

class PedidoException(s: String, exception: Exception?): Exception(s, exception)
{
    constructor(s: String) : this(s, null)
}