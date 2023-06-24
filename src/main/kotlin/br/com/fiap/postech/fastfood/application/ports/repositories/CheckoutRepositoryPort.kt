package br.com.fiap.postech.fastfood.application.ports.repositories

import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.CheckoutEntity
import br.com.fiap.postech.fastfood.application.domain.models.Checkout

interface CheckoutRepositoryPort {

    fun enviaCheckout(checkout: Checkout): CheckoutEntity
}