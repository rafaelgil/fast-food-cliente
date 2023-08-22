package br.com.fiap.postech.fastfood.domain.entity

import br.com.fiap.postech.fastfood.domain.exception.PagamentoException
import br.com.fiap.postech.fastfood.domain.valueObjets.FormaPagamento
import br.com.fiap.postech.fastfood.domain.valueObjets.StatusPagamento
import java.math.BigDecimal
import java.util.*

data class Pagamento(
    var id: UUID? = null,
    var formaPagamento: FormaPagamento,
    var valor: BigDecimal,
    var status: StatusPagamento,
    var qrCodeId:  UUID? = null,
    var qrCode: String? = null
){
    fun mudarStatus(status: StatusPagamento) {
        when {
            status == StatusPagamento.PAGO -> {
                mudarStatusPago()
            }

            status == StatusPagamento.NAO_PAGO -> {
                mudarStatusNaoPago()
            }
        }
    }

    private fun mudarStatusPago(){
        if(this.status != StatusPagamento.AGUARDANDO_PAGAMENTO ){
            lancarErroMudancaStatusIncorreto(StatusPagamento.PAGO)
        }

        this.status = StatusPagamento.PAGO
    }

    private fun mudarStatusNaoPago(){
        if(this.status != StatusPagamento.AGUARDANDO_PAGAMENTO ){
            lancarErroMudancaStatusIncorreto(StatusPagamento.NAO_PAGO)
        }

        this.status = StatusPagamento.NAO_PAGO
    }

    private fun lancarErroMudancaStatusIncorreto(status: StatusPagamento) {
        throw PagamentoException("Pagamento ${this.id} com status ${this.status.descricao} não pode mudar para ${status.descricao}")
    }
}


