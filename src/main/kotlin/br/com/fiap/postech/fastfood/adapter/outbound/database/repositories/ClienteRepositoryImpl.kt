package br.com.fiap.postech.fastfood.adapter.outbound.database.repositories

import br.com.fiap.postech.fastfood.adapter.outbound.database.entities.ClienteEntity
import br.com.fiap.postech.fastfood.application.domain.models.Cliente
import br.com.fiap.postech.fastfood.application.ports.repositories.ClienteRepositoryPort
import org.springframework.stereotype.Component

@Component
class ClienteRepositoryImpl(
    private val clienteRepositorySpring: ClienteRepositorySpring
): ClienteRepositoryPort {

    override fun cadastrar(cliente: Cliente) {
        val clienteEntity = ClienteEntity(
            cpf = cliente.cpf.cpf, nome = cliente.nome.nome, email = cliente.email.email
        )
        clienteRepositorySpring.save(clienteEntity)
    }
}