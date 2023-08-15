package br.com.fiap.postech.fastfood.domain.valueObjets


enum class StatusPagamento() {
    APROVADO,
    NAO_APROVADO
}

enum class FormaPagamento(val formaPagamento: String) {
    QR_CODE("qr code")
}