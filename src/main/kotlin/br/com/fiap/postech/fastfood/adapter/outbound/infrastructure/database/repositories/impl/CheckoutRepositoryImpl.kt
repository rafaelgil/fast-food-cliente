package br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.repositories.impl

import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.repositories.CheckoutRepositorySpring
import br.com.fiap.postech.fastfood.application.domain.extension.toCheckoutEntity
import br.com.fiap.postech.fastfood.application.domain.models.Checkout
import br.com.fiap.postech.fastfood.application.ports.repositories.CheckoutRepositoryPort
import org.springframework.stereotype.Component

@Component
class CheckoutRepositoryImpl(
        private val checkoutRepositorySpring: CheckoutRepositorySpring
): CheckoutRepositoryPort {

    override fun enviaCheckout(checkout: Checkout) {
        checkoutRepositorySpring.save(checkout.toCheckoutEntity())
    }
}