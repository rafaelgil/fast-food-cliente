package br.com.fiap.postech.fastfood.cliente.domain.usecase.cliente

import br.com.fiap.postech.fastfood.cliente.domain.entity.Cliente
import br.com.fiap.postech.fastfood.cliente.domain.repository.ClienteRepository

class BuscarClientePorCPFUseCase(
    private val clienteRepository: ClienteRepository
) {

    fun executa(cpf: String): Cliente {
        return clienteRepository.buscarClientePorCpf(cpf)
    }
}