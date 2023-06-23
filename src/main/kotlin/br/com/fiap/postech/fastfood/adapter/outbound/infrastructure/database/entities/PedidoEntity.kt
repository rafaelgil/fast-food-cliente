package br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities

import jakarta.persistence.*
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
    var sobremesaId: UUID?
)
