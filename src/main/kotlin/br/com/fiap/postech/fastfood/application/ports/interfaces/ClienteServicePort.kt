package br.com.fiap.postech.fastfood.application.ports.interfaces

import br.com.fiap.postech.fastfood.application.domain.dtos.ClienteDTO

interface ClienteServicePort {

    fun cadastrar(cliente: ClienteDTO)

    fun buscarClientePorCpf(cpf: String): ClienteDTO
}