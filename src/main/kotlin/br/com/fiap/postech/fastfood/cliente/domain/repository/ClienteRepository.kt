package br.com.fiap.postech.fastfood.cliente.domain.repository

import br.com.fiap.postech.fastfood.cliente.domain.entity.Cliente
import java.util.UUID

interface ClienteRepository {
    fun cadastrar(cliente: Cliente): Cliente

    fun buscarClientePorCpf(cpf: String): Cliente

    fun buscarCPFouEmailDuplicado(cpf: String, email: String): Boolean

    fun buscarPorId(id: UUID): Cliente

    fun excluirCliente(cliente: Cliente): Int

    fun buscarClientePorNomeCpfEmail(nome: String, cpf: String, email: String): Cliente
}