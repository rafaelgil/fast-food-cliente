package br.com.fiap.postech.fastfood.domain.usecase.cliente

import br.com.fiap.postech.fastfood.domain.exception.ViolatesUniqueConstraintException
import br.com.fiap.postech.fastfood.domain.entity.Cliente
import br.com.fiap.postech.fastfood.domain.repository.ClienteRepository

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