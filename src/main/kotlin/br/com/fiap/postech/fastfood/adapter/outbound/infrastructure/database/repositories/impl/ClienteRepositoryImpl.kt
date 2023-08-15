package br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.repositories.impl

import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.ClienteEntity
import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.repositories.ClienteRepositorySpring
import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.extension.toClienteEntity
import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.extension.toClienteResponseDTO
import br.com.fiap.postech.fastfood.application.domain.dtos.ClienteResponseDTO
import br.com.fiap.postech.fastfood.domain.entity.Cliente
import br.com.fiap.postech.fastfood.application.ports.repositories.ClienteRepositoryPort
import org.springframework.stereotype.Component
import java.util.*

@Component
class ClienteRepositoryImpl(
    private val clienteRepositorySpring: ClienteRepositorySpring
): ClienteRepositoryPort {

    override fun cadastrar(cliente: Cliente): ClienteResponseDTO {
        val clienteEntity : ClienteEntity = clienteRepositorySpring.save(cliente.toClienteEntity())
        return clienteEntity.toClienteResponseDTO()
    }

    override fun buscarClientePorCpf(cpf: String): ClienteResponseDTO {
        return clienteRepositorySpring.findByCpf(cpf).toClienteResponseDTO()
    }

    override fun buscarClientePorId(id: UUID): ClienteResponseDTO {
        return clienteRepositorySpring.findById(id).get().toClienteResponseDTO()
    }

    override fun buscarCPFouEmailDuplicado(cpf: String, email: String): Boolean {
        return clienteRepositorySpring.existsCpfOrEmail(cpf,email)
    }
}