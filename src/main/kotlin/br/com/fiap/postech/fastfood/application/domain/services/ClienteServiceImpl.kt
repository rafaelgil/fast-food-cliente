package br.com.fiap.postech.fastfood.application.domain.services

import br.com.fiap.postech.fastfood.application.domain.dtos.ClienteDTO
import br.com.fiap.postech.fastfood.application.domain.dtos.ClienteResponseDTO
import br.com.fiap.postech.fastfood.application.domain.exception.NotFoundEntityException
import br.com.fiap.postech.fastfood.application.domain.exception.ViolatesUniqueConstraintException
import br.com.fiap.postech.fastfood.application.domain.extension.toClienteModel
import br.com.fiap.postech.fastfood.application.ports.repositories.ClienteRepositoryPort
import br.com.fiap.postech.fastfood.application.ports.interfaces.ClienteServicePort
import java.util.*

class ClienteServiceImpl(
    private val clienteRepositoryPort: ClienteRepositoryPort
): ClienteServicePort {

    override fun cadastrar(clienteDTO: ClienteDTO): ClienteResponseDTO {
        val cliente = clienteDTO.toClienteModel()
        val valorDuplicado = clienteRepositoryPort.buscarCPFouEmailDuplicado(
            cliente.cpf.cpf, cliente.email.email
        )
        if (valorDuplicado) {
            throw ViolatesUniqueConstraintException("CPF ou E-mail já cadastrados!")
        }
        return clienteRepositoryPort.cadastrar(clienteDTO.toClienteModel())
    }

    override fun buscarClientePorCpf(cpf: String): ClienteResponseDTO {
        return clienteRepositoryPort.buscarClientePorCpf(cpf)
    }

    override fun buscarClientePorId(id: UUID): ClienteResponseDTO {
        return clienteRepositoryPort.buscarClientePorId(id)
    }
}