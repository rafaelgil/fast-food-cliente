package br.com.fiap.postech.fastfood.cliente.domain.usecase.cliente

import br.com.fiap.postech.fastfood.cliente.domain.entity.Cliente
import br.com.fiap.postech.fastfood.cliente.domain.repository.ClienteRepository
import java.util.*

class BuscarClientePorIdUseCase(
    private val clienteRepository: ClienteRepository
) {

    private val logger = org.slf4j.LoggerFactory.getLogger(this::class.java)

    fun executa(id: UUID): Cliente {
        logger.info("Buscando cliente por id: ${id}")

        return clienteRepository.buscarPorId(id)
    }
}