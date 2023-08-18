package br.com.fiap.postech.fastfood.adapter.presenter

import br.com.fiap.postech.fastfood.adapter.gateway.schema.ClienteSchema
import br.com.fiap.postech.fastfood.domain.entity.Cliente
import br.com.fiap.postech.fastfood.domain.valueObjets.CPF
import br.com.fiap.postech.fastfood.domain.valueObjets.Email
import br.com.fiap.postech.fastfood.domain.valueObjets.Nome
import java.util.*

data class ClienteRequest (
    var cpf: String,
    var nome: String,
    var email: String
)

data class ClienteResponse (
    var id: UUID? = null,
    var cpf: String? = null,
    var nome: String? = null,
    var email: String? = null
)

fun ClienteRequest.toCliente(): Cliente {
    return Cliente(
        cpf = CPF(this.cpf),
        nome = Nome(this.nome),
        email = Email(this.email)
    )
}

fun Cliente.toClienteResponse(): ClienteResponse {
    return ClienteResponse(
        id = this.id,
        nome = this.nome.nome,
        cpf = this.cpf.cpf,
        email = this.email.email
    )
}

fun Cliente.toClienteScheme(id: UUID? = null): ClienteSchema {
    return ClienteSchema(
        id = id,
        cpf = this.cpf.cpf,
        nome = this.nome.nome,
        email = this.email.email
    )
}

fun ClienteSchema.toCliente(): Cliente {
    return Cliente(
        id = this.id,
        cpf = CPF(this.cpf),
        nome = Nome(this.nome),
        email = Email(this.email)
    )
}