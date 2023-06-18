package br.com.fiap.postech.fastfood.application.domain.extension

import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.ClienteEntity
import br.com.fiap.postech.fastfood.application.domain.dtos.ClienteDTO
import br.com.fiap.postech.fastfood.application.domain.models.Cliente
import br.com.fiap.postech.fastfood.application.domain.valueObjets.CPF
import br.com.fiap.postech.fastfood.application.domain.valueObjets.Email
import br.com.fiap.postech.fastfood.application.domain.valueObjets.Nome

fun ClienteDTO.toClienteModel(): Cliente {
    return Cliente(
        cpf = CPF(this.cpf),
        nome = Nome(this.nome),
        email = Email(this.email)
    )
}

fun Cliente.toClienteEntity(): ClienteEntity {
    return ClienteEntity(
        cpf = this.cpf.cpf,
        nome = this.nome.nome,
        email = this.email.email
    )
}