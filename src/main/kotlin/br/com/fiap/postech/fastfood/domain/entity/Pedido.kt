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
    var dataRecebimento: LocalDateTime? = null,
    var status: StatusPedido
){
    fun valorTotal() = itens.sumOf { BigDecimal(it.quantidade).multiply(it.preco) }

    fun mudarStatus(status: StatusPedido) {

        when {
            status == StatusPedido.RECEBIDO -> {
                mudarStatusRecebido()
            }

            status == StatusPedido.EM_PREPARACAO -> {
                mudarStatusEmPreparacao()
            }

            status == StatusPedido.PRONTO -> {
                mudarStatusPronto()
            }

            status == StatusPedido.FINALIZADO -> {
                mudarStatusFinalizado()
            }
        }
    }

    private fun mudarStatusRecebido() {
        if( this.status != StatusPedido.AGUARDANDO_PAGAMENTO) {
            lancarErroMudancaStatusIncorreto(StatusPedido.RECEBIDO)
        }

        this.status = StatusPedido.RECEBIDO
        this.dataRecebimento = LocalDateTime.now()
    }

    private fun mudarStatusEmPreparacao() {
        if( this.status != StatusPedido.RECEBIDO) {
            lancarErroMudancaStatusIncorreto(StatusPedido.EM_PREPARACAO)
        }

        this.status = StatusPedido.EM_PREPARACAO
    }

    private fun mudarStatusPronto() {
        if( this.status != StatusPedido.EM_PREPARACAO) {
            lancarErroMudancaStatusIncorreto(StatusPedido.PRONTO)
        }

        this.status = StatusPedido.PRONTO
    }

    private fun mudarStatusFinalizado() {
        if( this.status != StatusPedido.PRONTO) {
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

