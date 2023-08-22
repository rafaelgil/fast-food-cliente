package br.com.fiap.postech.fastfood.domain.valueObjets

enum class StatusPedido(val status: String) {
    INICIADO("Iniciado"),
    AGUARDANDO_PAGAMENTO("Aguardando Pagamento"),
    RECEBIDO("Recebido"),
    EM_PREPARACAO("Em preparação"),
    PRONTO("Pronto"),
    FINALIZADO("Finalizado"),
    CANCELADO("Cancelado"),
    EM_ENTREGA("Em entrega")

}