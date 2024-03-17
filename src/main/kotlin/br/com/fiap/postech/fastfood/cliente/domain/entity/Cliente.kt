package br.com.fiap.postech.fastfood.cliente.domain.entity

import br.com.fiap.postech.fastfood.cliente.domain.valueObjets.*
import org.joda.time.LocalDateTime
import java.util.UUID

data class Cliente (

    var id: UUID? = null,
    var cpf: CPF? = null,
    var nome: Nome? = null,
    var email: Email? = null,
    var endereco: Endereco? = null,
    var telefone: Telefone? = null
)