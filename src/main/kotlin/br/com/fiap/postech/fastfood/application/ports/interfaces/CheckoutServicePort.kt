package br.com.fiap.postech.fastfood.application.ports.interfaces

import br.com.fiap.postech.fastfood.application.domain.dtos.CheckoutDTO

interface CheckoutServicePort {

    fun enviaParaFila(checkout: CheckoutDTO)
}