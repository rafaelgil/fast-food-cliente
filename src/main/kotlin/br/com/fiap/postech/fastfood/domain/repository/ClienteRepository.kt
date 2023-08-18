package br.com.fiap.postech.fastfood.domain.repository

import br.com.fiap.postech.fastfood.domain.entity.Cliente

interface ClienteRepository {
    fun cadastrar(cliente: Cliente): Cliente

    fun buscarClientePorCpf(cpf: String): Cliente

    fun buscarCPFouEmailDuplicado(cpf: String, email: String): Boolean
}