package br.com.fiap.postech.fastfood.domain.entity

import br.com.fiap.postech.fastfood.domain.exception.PedidoException
import br.com.fiap.postech.fastfood.domain.valueObjets.StatusPedido
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

data class Pedido(
    var id: UUID? = null,
    var cliente: Cliente,
    var itens: List<ItemPedido> = mutableListOf(),
    var data: LocalDateTime,
    var status: StatusPedido
){
    fun valorTotal() = itens.sumOf { BigDecimal(it.quantidade).multiply(it.preco) }

    fun mudarStatus(status: StatusPedido) {

        when {
            status == StatusPedido.AGUARDANDO_PAGAMENTO -> {
                mudarStatusAguardandoPagamento()
            }

            status == StatusPedido.EM_PREPARACAO -> {
                mudarStatusEmPreparacao()
            }

            status == StatusPedido.CANCELADO -> {
                mudarStatusCancelado()
            }

            status == StatusPedido.EM_ENTREGA -> {
                mudarStatusEmEntrega()
            }

            status == StatusPedido.FINALIZADO -> {
                mudarStatusFinalizado()
            }
        }
    }

    private fun mudarStatusAguardandoPagamento() {
        if( this.status != StatusPedido.INICIADO) {
            lancarErroMudancaStatusIncorreto(StatusPedido.AGUARDANDO_PAGAMENTO)
        }

        this.status = StatusPedido.AGUARDANDO_PAGAMENTO
    }

    private fun mudarStatusEmPreparacao() {
        if( this.status != StatusPedido.AGUARDANDO_PAGAMENTO) {
            lancarErroMudancaStatusIncorreto(StatusPedido.EM_PREPARACAO)
        }

        this.status = StatusPedido.EM_PREPARACAO
    }

    private fun mudarStatusCancelado() {
        if( this.status != StatusPedido.AGUARDANDO_PAGAMENTO) {
            lancarErroMudancaStatusIncorreto(StatusPedido.CANCELADO)
        }

        this.status = StatusPedido.CANCELADO
    }

    private fun mudarStatusEmEntrega() {
        if( this.status != StatusPedido.EM_PREPARACAO) {
            lancarErroMudancaStatusIncorreto(StatusPedido.EM_ENTREGA)
        }

        this.status = StatusPedido.EM_ENTREGA
    }

    private fun mudarStatusFinalizado() {
        if( this.status != StatusPedido.EM_ENTREGA) {
            lancarErroMudancaStatusIncorreto(StatusPedido.FINALIZADO)
        }

        this.status = StatusPedido.FINALIZADO
    }

    private fun lancarErroMudancaStatusIncorreto(status: StatusPedido) {
        throw PedidoException("O pedido não pode mudar de status ${this.status.status} para ${status.status}")
    }

}

data class ItemPedido(
    var id: UUID? = null,
    var produto: Produto,
    var quantidade: Int,
    var preco: BigDecimal,
)

