package br.com.fiap.postech.fastfood.cliente.domain.usecase.cliente

import br.com.fiap.postech.fastfood.cliente.domain.entity.Cliente
import br.com.fiap.postech.fastfood.cliente.domain.exception.ClienteNotFoundException
import br.com.fiap.postech.fastfood.cliente.domain.repository.ClienteRepository

class ExcluirClienteUseCase(
    private val clienteRepository: ClienteRepository
) {
    fun executa(cliente: Cliente): Int {
        val clienteEncontrado = clienteRepository.buscarClientePorNomeCpfEmail(cliente.nome.toString(), cliente.cpf.toString(), cliente.email.toString())

        if (clienteEncontrado == null) {
            throw ClienteNotFoundException("Cliente não encontrado.")
        }

        return clienteRepository.excluirCliente(cliente)
    }
}