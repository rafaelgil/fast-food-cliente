package br.com.fiap.postech.fastfood.application.domain.valueObjets

enum class StatusCheckout(val status: String) {
    PAGAMENTO_APROVADO("Pagamento Aprovado"),
    PAGAMENTO_NEGADO("Pagamento Negado"),
    ENVIADO("Enviado")
}

enum class FormaPagamento(val formaPagamento: String) {
    QR_CODE("qr code")
}