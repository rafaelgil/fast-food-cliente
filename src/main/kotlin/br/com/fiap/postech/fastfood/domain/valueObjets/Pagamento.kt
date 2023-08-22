package br.com.fiap.postech.fastfood.domain.valueObjets


enum class StatusPagamento(val descricao: String) {
    AGUARDANDO_PAGAMENTO("Aguardando Pagamento"),
    PAGO("Pago"),
    NAO_PAGO("Não Pago")
}

enum class FormaPagamento(val formaPagamento: String) {
    QR_CODE("QR_CODE")
}