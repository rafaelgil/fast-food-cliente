package br.com.fiap.postech.fastfood.application.domain.extension

import br.com.fiap.postech.fastfood.application.domain.dtos.ClienteDTO
import br.com.fiap.postech.fastfood.domain.entity.Cliente
import br.com.fiap.postech.fastfood.domain.valueObjets.CPF
import br.com.fiap.postech.fastfood.domain.valueObjets.Email
import br.com.fiap.postech.fastfood.domain.valueObjets.Nome

fun ClienteDTO.toClienteModel(): Cliente {
    return Cliente(
        id = this.id,
        cpf = CPF(this.cpf ?: ""),
        nome = Nome(this.nome ?: ""),
        email = Email(this.email ?: "")
    )
}

fun Cliente.toClienteDTO(): ClienteDTO {
    return ClienteDTO(
        id = this.id,
        cpf = this.cpf.toString(),
        nome = this.nome.toString(),
        email = this.email.toString()
    )
}
