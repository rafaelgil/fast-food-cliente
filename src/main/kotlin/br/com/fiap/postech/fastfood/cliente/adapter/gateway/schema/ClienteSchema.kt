package br.com.fiap.postech.fastfood.cliente.adapter.gateway.schema

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@Entity(name = "cliente")
class ClienteSchema (

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null,

    @Column
    var cpf: String,

    @Column
    var nome: String,

    @Column
    var email: String,

    @Column
    var endereco: String,

    @Column
    var telefone: String,

    @Column
    var excluidoEm: LocalDateTime? = null,
)