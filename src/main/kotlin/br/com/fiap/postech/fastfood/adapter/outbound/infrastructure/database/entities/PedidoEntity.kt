package br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities

import br.com.fiap.postech.fastfood.application.domain.valueObjets.StatusPedido
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.UUID

@Entity(name="pedido")
data class PedidoEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null,

    @Column
    var clienteId: UUID?,

    @Column
    var lancheId: UUID?,

    @Column
    var bebidaId: UUID?,

    @Column
    var acompanhamentoId: UUID?,

    @Column
    var sobremesaId: UUID?,

    @Column
    var dataPedido: LocalDateTime?,

    @Column
    var status: StatusPedido?,

    @OneToOne(mappedBy = "pedido")
    var checkout: CheckoutEntity?
)
