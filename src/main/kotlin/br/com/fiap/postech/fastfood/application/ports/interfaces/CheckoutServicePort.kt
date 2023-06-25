package br.com.fiap.postech.fastfood.application.ports.interfaces

import br.com.fiap.postech.fastfood.application.domain.dtos.CheckoutDTO
import br.com.fiap.postech.fastfood.application.domain.dtos.CheckoutRequest

interface CheckoutServicePort {

    fun enviaParaFila(checkoutRequest: CheckoutRequest): CheckoutDTO
}