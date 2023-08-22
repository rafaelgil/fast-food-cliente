package br.com.fiap.postech.fastfood.adapter.presenter

import br.com.fiap.postech.fastfood.adapter.gateway.schema.CheckoutSchema
import br.com.fiap.postech.fastfood.adapter.gateway.schema.PagamentoSchema
import br.com.fiap.postech.fastfood.domain.entity.Pagamento
import br.com.fiap.postech.fastfood.domain.valueObjets.StatusPagamento
import java.math.BigDecimal
import java.util.*


data class PagamentoResponse(
    var id: UUID? = null,
    var formaPagamento: String,
    var valor: BigDecimal,
    var status: String,
    var qrCodeId:  UUID? = null,
    var qrCode: String? = null
)

fun Pagamento.toPagamentoSchema(status: StatusPagamento = StatusPagamento.AGUARDANDO_PAGAMENTO) =
    PagamentoSchema(
        id = this.id,
        formaPagamento = this.formaPagamento,
        valor = this.valor,
        status = status,
        qrCodeId = this.qrCodeId,
        qrCode = this.qrCode
    )

fun PagamentoSchema.toPagamento() =
    Pagamento(
        id = this.id,
        formaPagamento = this.formaPagamento,
        valor = this.valor,
        status = this.status,
        qrCodeId = this.qrCodeId,
        qrCode = this.qrCode
    )

fun Pagamento.toResponse() =
    PagamentoResponse(
        id = this.id,
        formaPagamento = this.formaPagamento.name,
        valor = this.valor,
        status = this.status.name,
        qrCodeId = this.qrCodeId,
        qrCode = this.qrCode
    )