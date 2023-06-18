package br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities

import jakarta.persistence.*
import java.util.*

@Entity(name = "cliente")
class ClienteEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null,

    @Column
    var cpf: String,

    @Column
    var nome: String,

    @Column
    var email: String
)