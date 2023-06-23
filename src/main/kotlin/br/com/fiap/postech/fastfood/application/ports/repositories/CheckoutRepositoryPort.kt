package br.com.fiap.postech.fastfood.application.ports.repositories

import br.com.fiap.postech.fastfood.application.domain.models.Checkout

interface CheckoutRepositoryPort {

    fun enviaCheckout(checkout: Checkout)
}