package br.com.fiap.postech.fastfood.cliente.domain.usecase.cliente

import br.com.fiap.postech.fastfood.adapter.gateway.events.producer.SQSClienteProducer
import br.com.fiap.postech.fastfood.cliente.adapter.presenter.toEventoClienteInativo
import br.com.fiap.postech.fastfood.cliente.domain.exception.ViolatesUniqueConstraintException
import br.com.fiap.postech.fastfood.cliente.domain.entity.Cliente
import br.com.fiap.postech.fastfood.cliente.domain.repository.ClienteRepository
import java.util.UUID

class AtualizarStatusClienteUseCase (
    private val clienteRepository: ClienteRepository,
    private val sqsClienteProducer: SQSClienteProducer
) {

    private val logger = org.slf4j.LoggerFactory.getLogger(this::class.java)

    fun executa(id: UUID, status: String): Cliente {

        val cliente = clienteRepository.buscarPorId(id)
        cliente.atualizarStatus(status)

        logger.info("Atualizando status do cliente: $cliente")

        val clienteAtualizado = clienteRepository.atualizar(cliente)

        sqsClienteProducer.sendProducaoMessage(clienteAtualizado.toEventoClienteInativo())

        return clienteAtualizado
    }
}