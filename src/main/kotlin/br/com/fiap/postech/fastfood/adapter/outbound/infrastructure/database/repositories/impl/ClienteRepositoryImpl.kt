package br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.repositories.impl

import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.repositories.ClienteRepositorySpring
import br.com.fiap.postech.fastfood.application.domain.dtos.ClienteDTO
import br.com.fiap.postech.fastfood.application.domain.extension.toClienteDTO
import br.com.fiap.postech.fastfood.application.domain.extension.toClienteEntity
import br.com.fiap.postech.fastfood.application.domain.models.Cliente
import br.com.fiap.postech.fastfood.application.ports.repositories.ClienteRepositoryPort
import org.springframework.stereotype.Component

@Component
class ClienteRepositoryImpl(
    private val clienteRepositorySpring: ClienteRepositorySpring
): ClienteRepositoryPort {

    override fun cadastrar(cliente: Cliente) {
        clienteRepositorySpring.save(cliente.toClienteEntity())
    }

    override fun buscarClientePorCpf(cpf: String): ClienteDTO {
        return clienteRepositorySpring.findByCpf(cpf).toClienteDTO()
    }
}