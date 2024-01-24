package br.com.fiap.postech.fastfood.cliente.domain.usecase.cliente

import br.com.fiap.postech.fastfood.cliente.domain.exception.ViolatesUniqueConstraintException
import br.com.fiap.postech.fastfood.cliente.domain.entity.Cliente
import br.com.fiap.postech.fastfood.cliente.domain.repository.ClienteRepository

class CadastrarClienteUseCase (
    private val clienteRepository: ClienteRepository
) {
    fun executa(cliente: Cliente): Cliente {

        val valorDuplicado = clienteRepository.buscarCPFouEmailDuplicado(cliente.cpf!!.cpf, cliente.email!!.email)
        if (valorDuplicado) {
            throw ViolatesUniqueConstraintException("CPF ou E-mail já cadastrados!")
        }
        return clienteRepository.cadastrar(cliente)
    }
}