package br.com.fiap.postech.fastfood.application.domain.services

import br.com.fiap.postech.fastfood.application.domain.dtos.ClienteDTO
import br.com.fiap.postech.fastfood.application.domain.models.Cliente
import br.com.fiap.postech.fastfood.application.domain.valueObjets.CPF
import br.com.fiap.postech.fastfood.application.domain.valueObjets.Email
import br.com.fiap.postech.fastfood.application.domain.valueObjets.Nome
import br.com.fiap.postech.fastfood.application.ports.repositories.ClienteRepositoryPort
import br.com.fiap.postech.fastfood.application.ports.interfaces.ClienteServicePort

class ClienteServiceImpl(
    private val clienteRepositoryPort: ClienteRepositoryPort
): ClienteServicePort {

    override fun cadastrar(clienteDTO: ClienteDTO) {
        val cliente = Cliente(
            cpf = CPF(clienteDTO.cpf),
            nome = Nome(clienteDTO.nome),
            email = Email(clienteDTO.email)
        )
        clienteRepositoryPort.cadastrar(cliente)
    }
}