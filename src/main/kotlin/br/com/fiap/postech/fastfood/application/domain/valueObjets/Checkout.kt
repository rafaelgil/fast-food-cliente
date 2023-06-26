package br.com.fiap.postech.fastfood.application.domain.valueObjets

enum class StatusCheckout(val status: String) {
    ENVIADO("Enviado"),
    REENVIADO("Reenviado"),
    RECEBIDO("Recebido"),
    CANCELADO("Cancelado")
}