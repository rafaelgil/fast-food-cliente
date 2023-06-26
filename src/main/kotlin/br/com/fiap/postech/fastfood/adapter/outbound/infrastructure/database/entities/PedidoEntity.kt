package br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities

import br.com.fiap.postech.fastfood.application.domain.valueObjets.StatusPedido
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.UUID
import jakarta.persistence.CascadeType.ALL

@Entity(name="pedido")
data class PedidoEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null,

    @OneToOne(cascade = [ALL])
    @JoinColumn(name = "lanche_id", referencedColumnName = "id")
    var lanche: ProdutoEntity?,

    @OneToOne(cascade = [ALL])
    @JoinColumn(name = "bebida_id", referencedColumnName = "id")
    var bebida: ProdutoEntity?,

    @OneToOne(cascade = [ALL])
    @JoinColumn(name = "acompanhamento_id", referencedColumnName = "id")
    var acompanhamento: ProdutoEntity?,

    @OneToOne(cascade = [ALL])
    @JoinColumn(name = "sobremesa_id", referencedColumnName = "id")
    var sobremesa: ProdutoEntity?,

    @OneToOne(cascade = arrayOf(ALL))
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    var cliente: ClienteEntity?,

    @Column
    var dataPedido: LocalDateTime?,

    @Column
    var status: StatusPedido?,

    @OneToOne(mappedBy = "pedido")
    var checkout: CheckoutEntity?
)
