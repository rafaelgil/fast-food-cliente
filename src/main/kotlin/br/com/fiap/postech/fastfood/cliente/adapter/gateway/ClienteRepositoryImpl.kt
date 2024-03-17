package br.com.fiap.postech.fastfood.cliente.adapter.gateway

import br.com.fiap.postech.fastfood.cliente.adapter.gateway.jpa.ClienteRepositoryJpa
import br.com.fiap.postech.fastfood.cliente.adapter.presenter.toCliente
import br.com.fiap.postech.fastfood.cliente.adapter.presenter.toClienteScheme
import br.com.fiap.postech.fastfood.cliente.domain.entity.Cliente
import br.com.fiap.postech.fastfood.cliente.domain.exception.ClienteNotFoundException
import br.com.fiap.postech.fastfood.cliente.domain.repository.ClienteRepository
import java.util.*

class ClienteRepositoryImpl(
    private val clienteRepositoryJpa: ClienteRepositoryJpa
): ClienteRepository {

    override fun cadastrar(cliente: Cliente): Cliente {
        return clienteRepositoryJpa.save(cliente.toClienteScheme()).toCliente()
    }

    override fun buscarClientePorCpf(cpf: String): Cliente {
        return clienteRepositoryJpa.findByCpf(cpf).toCliente()
    }

    override fun buscarCPFouEmailDuplicado(cpf: String, email: String): Boolean {
        return clienteRepositoryJpa.existsCpfOrEmail(cpf, email)
    }

    override fun buscarPorId(id: UUID) =
        clienteRepositoryJpa.findById(id).orElseThrow{ ClienteNotFoundException("Cliente ${id} não encontrado") }.toCliente()

    override fun excluirCliente(cliente: Cliente): Int =
            clienteRepositoryJpa.excluirLogicamentePorCpf(cliente.cpf.toString())

    override fun buscarClientePorNomeCpfEmail(nome: String, cpf: String, email: String, endereco: String, telefone: String): Cliente {
        return clienteRepositoryJpa.buscarClientePorNomeCpfEmail(nome, cpf, email, endereco, telefone).toCliente()
    }

}