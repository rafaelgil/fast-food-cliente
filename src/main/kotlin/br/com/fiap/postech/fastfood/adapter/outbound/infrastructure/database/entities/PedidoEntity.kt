package br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities

import br.com.fiap.postech.fastfood.application.domain.valueObjets.StatusPedido
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.UUID
import jakarta.persistence.CascadeType.*

@Entity(name="pedido")
data class PedidoEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null,

    @OneToOne(cascade = [PERSIST])
    @JoinColumn(name = "lanche_id", referencedColumnName = "id")
    var lanche: ProdutoEntity?,

    @OneToOne(cascade = [PERSIST])
    @JoinColumn(name = "bebida_id", referencedColumnName = "id")
    var bebida: ProdutoEntity?,

    @OneToOne(cascade = [PERSIST])
    @JoinColumn(name = "acompanhamento_id", referencedColumnName = "id")
    var acompanhamento: ProdutoEntity?,

    @OneToOne(cascade = [PERSIST])
    @JoinColumn(name = "sobremesa_id", referencedColumnName = "id")
    var sobremesa: ProdutoEntity?,

    @OneToOne(cascade = arrayOf(PERSIST))
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    var cliente: ClienteEntity?,

    @Column
    var data: LocalDateTime?,

    @Column
    var status: StatusPedido?,

    @OneToOne(mappedBy = "pedido")
    var checkout: CheckoutEntity?
)
