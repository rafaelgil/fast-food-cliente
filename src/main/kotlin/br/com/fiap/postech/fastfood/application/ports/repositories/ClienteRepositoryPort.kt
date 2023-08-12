package br.com.fiap.postech.fastfood.application.ports.repositories

import br.com.fiap.postech.fastfood.application.domain.dtos.ClienteResponseDTO
import br.com.fiap.postech.fastfood.domain.entity.Cliente
import java.util.UUID

interface ClienteRepositoryPort {

    fun cadastrar(cliente: Cliente): ClienteResponseDTO

    fun buscarClientePorCpf(cpf: String): ClienteResponseDTO

    fun buscarClientePorId(id: UUID): ClienteResponseDTO

    fun buscarCPFouEmailDuplicado(cpf: String, email: String): Boolean
}