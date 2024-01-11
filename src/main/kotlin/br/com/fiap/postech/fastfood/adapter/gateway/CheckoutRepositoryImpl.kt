package br.com.fiap.postech.fastfood.adapter.gateway

import br.com.fiap.postech.fastfood.adapter.gateway.jpa.CheckoutRepositoryJpa
import br.com.fiap.postech.fastfood.adapter.presenter.toCheckout
import br.com.fiap.postech.fastfood.adapter.presenter.toCheckoutSchema
import br.com.fiap.postech.fastfood.domain.entity.Checkout
import br.com.fiap.postech.fastfood.domain.repository.CheckoutRepository

class CheckoutRepositoryImpl(
    private val checkoutRepositoryJpa: CheckoutRepositoryJpa
): CheckoutRepository {
    override fun cadastrar(checkout: Checkout): Checkout {
        return checkoutRepositoryJpa.save(checkout.toCheckoutSchema()).toCheckout()
    }
}