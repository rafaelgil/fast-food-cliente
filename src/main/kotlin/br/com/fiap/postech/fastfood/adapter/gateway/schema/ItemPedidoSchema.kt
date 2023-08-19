package br.com.fiap.postech.fastfood.adapter.gateway.schema

import jakarta.persistence.*
import java.math.BigDecimal
import java.util.*

@Entity(name = "itempedido")
@Table(name = "item_pedido")
data class ItemPedidoSchema (

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID? = null,

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    var pedido: PedidoSchema,

    @ManyToOne
    @JoinColumn(name = "produto_id")
    var produto: ProdutoSchema,

    @Column
    var preco: BigDecimal,

    @Column
    var quantidade: Int = 1
) {
    override fun toString(): String {
        return "ItemPedidoSchema(id=$id, pedido=${pedido.id}, produto=${produto.id}, preco=$preco, quantidade=$quantidade)"
    }
}