package br.com.fiap.postech.fastfood.application.ports.repositories

import br.com.fiap.postech.fastfood.application.domain.dtos.ClienteResponseDTO
import br.com.fiap.postech.fastfood.application.domain.models.Cliente

interface ClienteRepositoryPort {

    fun cadastrar(cliente: Cliente): ClienteResponseDTO

    fun buscarClientePorCpf(cpf: String): ClienteResponseDTO

    fun buscarCPFouEmailDuplicado(cpf: String, email: String): Boolean
}