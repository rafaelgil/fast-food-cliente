package br.com.fiap.postech.fastfood.domain.usecase.cliente

import br.com.fiap.postech.fastfood.domain.entity.Cliente
import br.com.fiap.postech.fastfood.domain.repository.ClienteRepository

class BuscarClientePorCPFUseCase(
    private val clienteRepository: ClienteRepository
) {

    fun executa(cpf: String): Cliente {
        return clienteRepository.buscarClientePorCpf(cpf)
    }
}