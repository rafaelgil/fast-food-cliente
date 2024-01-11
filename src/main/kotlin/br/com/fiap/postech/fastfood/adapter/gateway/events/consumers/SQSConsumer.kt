package br.com.fiap.postech.fastfood.adapter.gateway.events.consumers


import br.com.fiap.postech.fastfood.adapter.gateway.events.dtos.PagamentoEvent
import br.com.fiap.postech.fastfood.domain.usecase.pedido.MudarStatusPedidoUseCase
import br.com.fiap.postech.fastfood.domain.valueObjets.StatusPedido
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener
import org.springframework.stereotype.Component


@Component
class SQSConsumer(
    private val mudarStatusPedidoUseCase: MudarStatusPedidoUseCase,
) {

    @SqsListener(value = ["\${aws.queue.name}"])
    fun receiveMessage(message: String) {
        val event = ObjectMapper().readValue<PagamentoEvent>(message)

        mudarStatusPedidoUseCase.executa(event.pedidoId!!, StatusPedido.RECEBIDO)
    }

}