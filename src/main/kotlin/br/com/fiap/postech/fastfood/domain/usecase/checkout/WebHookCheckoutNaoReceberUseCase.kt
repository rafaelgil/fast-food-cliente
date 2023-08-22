package br.com.fiap.postech.fastfood.domain.usecase.checkout

import br.com.fiap.postech.fastfood.domain.entity.Pedido
import br.com.fiap.postech.fastfood.domain.repository.CheckoutRepository
import br.com.fiap.postech.fastfood.domain.usecase.pagamento.MudarStatusPagamentoUseCase
import br.com.fiap.postech.fastfood.domain.usecase.pedido.MudarStatusPedidoUseCase
import br.com.fiap.postech.fastfood.domain.valueObjets.StatusPagamento
import br.com.fiap.postech.fastfood.domain.valueObjets.StatusPedido
import java.util.*

class WebHookCheckoutNaoReceberUseCase(
    private val mudarStatusPagamentoUseCase: MudarStatusPagamentoUseCase,
    private val mudarStatusPedidoUseCase: MudarStatusPedidoUseCase,
    private val checkoutRepository: CheckoutRepository
) {
    fun executa(qrCodeId: UUID): Pedido {

        val pagamento = mudarStatusPagamentoUseCase.executa(qrCodeId, StatusPagamento.NAO_PAGO)

        val checkout = checkoutRepository.buscarPorPagamento(pagamento.id!!)

        return mudarStatusPedidoUseCase.executa(checkout.pedido.id!!, StatusPedido.CANCELADO)

    }

}