package br.com.fiap.postech.fastfood.application.ports.interfaces

import br.com.fiap.postech.fastfood.application.domain.dtos.ClienteDTO
import br.com.fiap.postech.fastfood.application.domain.dtos.ClienteResponseDTO
import java.util.UUID

interface ClienteServicePort {

    fun cadastrar(cliente: ClienteDTO): ClienteResponseDTO

    fun buscarClientePorCpf(cpf: String): ClienteResponseDTO

    fun buscarClientePorId(id: UUID): ClienteResponseDTO
}