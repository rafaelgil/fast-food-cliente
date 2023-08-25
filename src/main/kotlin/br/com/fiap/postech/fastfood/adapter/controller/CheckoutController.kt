package br.com.fiap.postech.fastfood.adapter.controller

import br.com.fiap.postech.fastfood.adapter.presenter.*
import br.com.fiap.postech.fastfood.domain.usecase.checkout.WebHookCheckoutPagoUseCase
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("checkouts")
class CheckoutController (
    private val webHookCheckoutPagoUseCase: WebHookCheckoutPagoUseCase
) {

    @PutMapping("/{qrCodeId}/webhook/pagar")
    fun receberPagamentoPedido(@PathVariable qrCodeId: UUID): PedidoResponse {
        return webHookCheckoutPagoUseCase.executa(qrCodeId).toResponse()
    }

}