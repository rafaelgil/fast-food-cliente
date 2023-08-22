package br.com.fiap.postech.fastfood.adapter.gateway.schema

import br.com.fiap.postech.fastfood.domain.valueObjets.StatusPedido
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@Entity(name="pedido")
data class PedidoSchema(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null,

    @OneToMany(mappedBy = "pedido", cascade = [CascadeType.ALL])
    var itens: List<ItemPedidoSchema> = mutableListOf(),

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    var cliente: ClienteSchema,

    @Column
    var data: LocalDateTime,

    @Column
    @Enumerated(EnumType.STRING)
    var status: StatusPedido,
)
