package br.com.fiap.postech.fastfood.domain.entity

import br.com.fiap.postech.fastfood.domain.valueObjets.StatusPedido
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

data class Pedido(
    var id: UUID? = null,
    var cliente: Cliente,
    var itens: List<ItemPedido> = mutableListOf(),
    var data: LocalDateTime,
    var status: StatusPedido
){
    fun valorTotal() = BigDecimal.TEN

    fun mudarStatus(status: StatusPedido) {
        this.status = status
    }
}

data class ItemPedido(
    var id: UUID? = null,
    var produto: Produto,
    var quantidade: Int,
    var preco: BigDecimal,
)

