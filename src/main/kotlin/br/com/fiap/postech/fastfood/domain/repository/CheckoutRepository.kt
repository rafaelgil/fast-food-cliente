package br.com.fiap.postech.fastfood.domain.repository

import br.com.fiap.postech.fastfood.domain.entity.Checkout

interface CheckoutRepository {
    fun cadastrar(checkout: Checkout): Checkout

}