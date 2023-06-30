package br.com.fiap.postech.fastfood.application.ports.repositories

import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.CheckoutEntity
import br.com.fiap.postech.fastfood.application.domain.models.Checkout
import br.com.fiap.postech.fastfood.application.domain.models.Pedido
import java.util.*

interface CheckoutRepositoryPort {

    fun enviaCheckout(checkout: Checkout): CheckoutEntity

    fun buscaCheckoutPeloPedido(pedido: Pedido): Optional<Checkout>
}