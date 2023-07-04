package br.com.fiap.postech.fastfood.adapter.inbound.extension

import br.com.fiap.postech.fastfood.adapter.inbound.request.ClienteRequest
import br.com.fiap.postech.fastfood.adapter.inbound.response.ClienteResponse
import br.com.fiap.postech.fastfood.application.domain.dtos.ClienteDTO
import br.com.fiap.postech.fastfood.application.domain.dtos.ClienteResponseDTO

fun ClienteResponseDTO.toClienteResponse(): ClienteResponse {
    return ClienteResponse(
        id = this.id,
        cpf = this.cpf,
        nome = this.nome,
        email = this.email
    )
}

fun ClienteRequest.toClienteDTO(): ClienteDTO {
    return ClienteDTO(
        cpf = this.cpf,
        nome = this.nome,
        email = this.email
    )
}
fun ClienteDTO.toClienteResponse(): ClienteResponse {
    return ClienteResponse(
        id = this.id,
        cpf = this.cpf,
        nome = this.nome,
        email = this.email
    )
}