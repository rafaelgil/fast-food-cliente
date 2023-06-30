package br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.repositories.impl

import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.CheckoutEntity
import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.PedidoEntity
import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.repositories.CheckoutRepositorySpring
import br.com.fiap.postech.fastfood.application.domain.extension.toCheckoutEntity
import br.com.fiap.postech.fastfood.application.domain.extension.toCheckoutModel
import br.com.fiap.postech.fastfood.application.domain.extension.toPedidoEntity
import br.com.fiap.postech.fastfood.application.domain.models.Checkout
import br.com.fiap.postech.fastfood.application.domain.models.Pedido
import br.com.fiap.postech.fastfood.application.ports.repositories.CheckoutRepositoryPort
import org.springframework.stereotype.Component
import java.util.*

@Component
class CheckoutRepositoryImpl(
        private val checkoutRepositorySpring: CheckoutRepositorySpring
): CheckoutRepositoryPort {

    override fun enviaCheckout(checkout: Checkout): CheckoutEntity {
        var checkoutEntity = checkout.toCheckoutEntity()
        checkoutRepositorySpring.save(checkoutEntity)
        return checkoutEntity
    }

    override fun buscaCheckoutPeloPedido(pedido: Pedido): Optional<Checkout> {
        var checkoutResult = checkoutRepositorySpring.findByPedido(pedido.toPedidoEntity())
        var checkout = checkoutResult.get()
        return Optional.of(checkout.toCheckoutModel())
    }
}