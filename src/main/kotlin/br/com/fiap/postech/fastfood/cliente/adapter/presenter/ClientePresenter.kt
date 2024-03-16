package br.com.fiap.postech.fastfood.cliente.adapter.presenter

import br.com.fiap.postech.fastfood.adapter.gateway.events.dtos.ClienteInativoEvent
import br.com.fiap.postech.fastfood.cliente.adapter.gateway.schema.ClienteSchema
import br.com.fiap.postech.fastfood.cliente.domain.entity.Cliente
import br.com.fiap.postech.fastfood.cliente.domain.valueObjets.*
import java.util.*

data class ClienteRequest (
    var cpf: String,
    var nome: String,
    var email: String,
    var endereco: String,
    var telefone: String
)

data class ClienteResponse (
    var id: UUID? = null,
    var cpf: String? = null,
    var nome: String? = null,
    var email: String? = null,
    var status: String? = null,
    var endereco: String? = null,
    var telefone: String? = null
)

fun ClienteRequest.toCliente(): Cliente {
    return Cliente(
        cpf = CPF(this.cpf),
        nome = Nome(this.nome),
        email = Email(this.email),
        status = "ATIVO",
        endereco = Endereco(this.endereco),
        telefone = Telefone(this.telefone)
    )
}

fun Cliente.toClienteResponse(): ClienteResponse {
    return ClienteResponse(
        id = this.id,
        nome = this.nome!!.nome,
        cpf = this.cpf!!.cpf,
        email = this.email!!.email,
        endereco = this.endereco!!.endereco,
        telefone = this.telefone!!.telefone,
        status = this.status
    )
}

fun Cliente.toClienteScheme(id: UUID? = null, status: String = "ATIVO"): ClienteSchema {
    return ClienteSchema(
        id = id,
        cpf = this.cpf!!.cpf,
        nome = this.nome!!.nome,
        email = this.email!!.email,
        endereco = this.endereco!!.endereco,
        telefone = this.telefone!!.telefone,
        status = status
    )
}

fun ClienteSchema.toCliente(): Cliente {
    return Cliente(
        id = this.id,
        cpf = CPF(this.cpf),
        nome = Nome(this.nome),
        email = Email(this.email),
        status = this.status,
        endereco = Endereco(this.endereco),
        telefone = Telefone(this.telefone)
    )
}

data class ClienteAutenticado (
        var mensagem: String,
        var token: String?
)

fun Cliente.toEventoClienteInativo() = ClienteInativoEvent(this.id)