package br.com.fiap.postech.fastfood.domain.valueObjets

enum class StatusPedido(val status: String) {
    INICIADO("Iniciado"),
    RECEBIDO("Recebido"),
    EM_PREPARACAO("Em preparação"),
    PRONTO("Pronto"),
    FINALIZADO("Finalizado")
}