package br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.extension

import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.ClienteEntity
import br.com.fiap.postech.fastfood.application.domain.dtos.ClienteDTO
import br.com.fiap.postech.fastfood.application.domain.dtos.ClienteResponseDTO
import br.com.fiap.postech.fastfood.application.domain.models.Cliente
import br.com.fiap.postech.fastfood.application.domain.valueObjets.CPF
import br.com.fiap.postech.fastfood.application.domain.valueObjets.Email
import br.com.fiap.postech.fastfood.application.domain.valueObjets.Nome

fun ClienteEntity.toClienteResponseDTO(): ClienteResponseDTO {
    return ClienteResponseDTO(
        id = this.id,
        cpf = this.cpf,
        nome = this.nome,
        email = this.email
    )
}

fun ClienteEntity.toClienteModel(): Cliente {
    return Cliente(
        id = this.id,
        cpf = CPF(this.cpf),
        nome = Nome(this.nome),
        email = Email(this.email)
    )
}

fun ClienteEntity.toClienteDTO(): ClienteDTO {
    return ClienteDTO(
        cpf = this.cpf,
        nome = this.nome,
        email = this.email
    )
}
fun Cliente.toClienteEntity(): ClienteEntity {
    return ClienteEntity(
        id = this.id,
        cpf = this.cpf.cpf,
        nome = this.nome.nome,
        email = this.email.email
    )
}