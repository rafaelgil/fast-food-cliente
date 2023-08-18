package br.com.fiap.postech.fastfood.adapter.gateway.schema

import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.CheckoutEntity
import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.ClienteEntity
import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.ProdutoEntity
import br.com.fiap.postech.fastfood.domain.valueObjets.StatusPedido
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.UUID
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode

@Entity(name="pedido")
data class PedidoSchema(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lanche_id", referencedColumnName = "id", insertable = false, updatable = false)
    var lanche: ProdutoSchema?,

//    @Column(name = "lanche_id")
//    var lancheId: UUID? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bebida_id", referencedColumnName = "id", insertable = false, updatable = false)
    var bebida: ProdutoSchema?,

//    @Column(name = "bebida_id")
//    var bebidaId: UUID? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "acompanhamento_id", referencedColumnName = "id", insertable = false, updatable = false)
    var acompanhamento: ProdutoSchema?,

//    @Column(name = "acompanhamento_id")
//    var acompanhamentoId: UUID? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sobremesa_id", referencedColumnName = "id", insertable = false, updatable = false)
    var sobremesa: ProdutoSchema?,

//    @Column(name = "sobremesa_id")
//    var sobremesaId: UUID? = null,

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "cliente_id", referencedColumnName = "id", insertable = false, updatable = false)
//    @Fetch(FetchMode.JOIN)
//    var cliente: ClienteEntity? = null,
//
//    @Column(name = "cliente_id")
//    var clienteId: UUID? = null,

    @Column
    var data: LocalDateTime?,

    @Column
    var status: StatusPedido?,

//    @OneToOne(mappedBy = "pedido")
//    var checkout: CheckoutEntity?,
)
