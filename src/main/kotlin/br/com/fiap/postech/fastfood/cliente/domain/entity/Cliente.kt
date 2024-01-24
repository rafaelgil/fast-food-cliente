package br.com.fiap.postech.fastfood.cliente.domain.entity

import br.com.fiap.postech.fastfood.cliente.domain.valueObjets.CPF
import br.com.fiap.postech.fastfood.cliente.domain.valueObjets.Email
import br.com.fiap.postech.fastfood.cliente.domain.valueObjets.Nome
import java.util.UUID

data class Cliente (

    var id: UUID? = null,
    var cpf: CPF? = null,
    var nome: Nome? = null,
    var email: Email? = null
)