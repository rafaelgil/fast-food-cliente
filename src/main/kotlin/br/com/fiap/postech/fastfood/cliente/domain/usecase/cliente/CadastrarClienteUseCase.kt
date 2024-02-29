package br.com.fiap.postech.fastfood.cliente.domain.usecase.cliente

import br.com.fiap.postech.fastfood.cliente.domain.exception.ViolatesUniqueConstraintException
import br.com.fiap.postech.fastfood.cliente.domain.entity.Cliente
import br.com.fiap.postech.fastfood.cliente.domain.repository.ClienteRepository

class CadastrarClienteUseCase (
    private val clienteRepository: ClienteRepository
) {

    private val logger = org.slf4j.LoggerFactory.getLogger(this::class.java)

    fun executa(cliente: Cliente): Cliente {

        logger.info("Cadastrando cliente: $cliente")

        val valorDuplicado = clienteRepository.buscarCPFouEmailDuplicado(cliente.cpf!!.cpf, cliente.email!!.email)
        if (valorDuplicado) {
            throw ViolatesUniqueConstraintException("CPF ou E-mail já cadastrados!")
        }

        return clienteRepository.cadastrar(cliente)
    }
}