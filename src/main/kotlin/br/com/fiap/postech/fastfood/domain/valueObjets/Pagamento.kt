package br.com.fiap.postech.fastfood.domain.valueObjets


enum class StatusPagamento() {
    AGUARDANDO_PAGAMENTO,
    PAGO,
    NAO_PAGO
}

enum class FormaPagamento(val formaPagamento: String) {
    QR_CODE("QR_CODE")
}