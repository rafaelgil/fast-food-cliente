package br.com.fiap.postech.fastfood.application.domain.models

import br.com.fiap.postech.fastfood.application.domain.valueObjets.CPF
import br.com.fiap.postech.fastfood.application.domain.valueObjets.Email
import br.com.fiap.postech.fastfood.application.domain.valueObjets.Nome
import java.util.UUID

data class Cliente (

    var id: UUID? = null,
    var cpf: CPF,
    var nome: Nome,
    var email: Email
)