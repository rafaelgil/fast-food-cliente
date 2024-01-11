package br.com.fiap.postech.fastfood.domain.repository

import br.com.fiap.postech.fastfood.domain.entity.Checkout
import java.util.UUID

interface CheckoutRepository {
    fun cadastrar(checkout: Checkout): Checkout
}