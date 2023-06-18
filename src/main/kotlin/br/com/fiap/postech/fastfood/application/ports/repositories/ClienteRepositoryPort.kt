package br.com.fiap.postech.fastfood.application.ports.repositories

import br.com.fiap.postech.fastfood.application.domain.models.Cliente

interface ClienteRepositoryPort {

    fun cadastrar(cliente: Cliente)
}