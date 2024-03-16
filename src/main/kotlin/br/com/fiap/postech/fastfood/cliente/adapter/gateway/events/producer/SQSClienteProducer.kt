package br.com.fiap.postech.fastfood.adapter.gateway.events.producer

import br.com.fiap.postech.fastfood.adapter.gateway.events.dtos.ClienteInativoEvent
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate
import org.springframework.messaging.Message
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Component

@Component
class SQSClienteProducer(
        private val queueMessagingTemplate: QueueMessagingTemplate,
        @Value("\${aws.queue.notificacao-cliente-inativo.name}")
        val queueProductionEvent: String,
) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    fun sendProducaoMessage(clienteEvent: ClienteInativoEvent) {
        val message: Message<String> = MessageBuilder.withPayload(ObjectMapper().writeValueAsString(clienteEvent))
            .build()
        queueMessagingTemplate.send(queueProductionEvent, message)

        logger.info("Evento do cliente ${clienteEvent.id} inativo enviada com sucesso")
    }
}