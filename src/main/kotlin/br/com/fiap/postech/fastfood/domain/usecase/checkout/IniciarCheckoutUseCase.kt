package br.com.fiap.postech.fastfood.domain.usecase.checkout

import br.com.fiap.postech.fastfood.domain.entity.Checkout
import br.com.fiap.postech.fastfood.domain.entity.Pagamento
import br.com.fiap.postech.fastfood.domain.entity.Pedido
import br.com.fiap.postech.fastfood.domain.repository.CheckoutRepository
import br.com.fiap.postech.fastfood.domain.usecase.pagamento.GerarPagamentoQrCodeUseCase
import br.com.fiap.postech.fastfood.domain.usecase.pedido.MudarStatusPedidoUseCase
import br.com.fiap.postech.fastfood.domain.valueObjets.StatusPedido
import java.time.LocalDateTime
import java.util.*

class IniciarCheckoutUseCase(
    private val gerarPagamentoQrCodeUseCase: GerarPagamentoQrCodeUseCase,
    private val mudarStatusPedidoUseCase: MudarStatusPedidoUseCase,
    private val checkoutRepository: CheckoutRepository
) {
    fun executa(id: UUID): Checkout {

        val pedido = mudarStatusPedidoUseCase.executa(id, StatusPedido.AGUARDANDO_PAGAMENTO)

        val pagamento = gerarPagamentoQrCodeUseCase.executa(pedido = pedido)

        val checkout = criarCheckout(pedido, pagamento)

        return checkoutRepository.cadastrar(checkout)
    }

    private fun criarCheckout(pedido: Pedido, pagamento: Pagamento): Checkout {
        return Checkout(
            pedido = pedido,
            pagamento = pagamento,
            data = LocalDateTime.now()
        );
    }
}