package br.com.fiap.postech.fastfood.adapter.gateway.events.consumers


import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener
import org.springframework.stereotype.Component

@Component
class SQSConsumer {

    @SqsListener("notificacao-pagamento-sync")
    fun receiveMessage(message: Map<String?, Any?>?) {
        println("SQS Message Received : ${message}")
    }


}