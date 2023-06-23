package br.com.fiap.postech.fastfood.application.domain.services

import br.com.fiap.postech.fastfood.application.domain.dtos.CheckoutDTO
import br.com.fiap.postech.fastfood.application.domain.extension.toCheckout
import br.com.fiap.postech.fastfood.application.ports.interfaces.CheckoutServicePort
import br.com.fiap.postech.fastfood.application.ports.repositories.CheckoutRepositoryPort

class CheckoutServiceImpl(
    private val checkoutRepositoryPort: CheckoutRepositoryPort
): CheckoutServicePort {

    override fun enviaParaFila(checkout: CheckoutDTO) {
        this.checkoutRepositoryPort.enviaCheckout(checkout.toCheckout())
    }
}