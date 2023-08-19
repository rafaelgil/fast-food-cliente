package br.com.fiap.postech.fastfood.adapter.gateway.schema

import br.com.fiap.postech.fastfood.domain.valueObjets.CategoriaProduto
import jakarta.persistence.*
import java.math.BigDecimal
import java.util.*

@Entity(name = "produto")
data class ItemPedidoSchema (

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID? = null,

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    var pedido: PedidoSchema,

    @ManyToOne
    @JoinColumn(name = "produto_id")
    var produtoSchema: ProdutoSchema,

    @Column
    var valor: BigDecimal,

    @Column
    var quantidade: Int = 1
)