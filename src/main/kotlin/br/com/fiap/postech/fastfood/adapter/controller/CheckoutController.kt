package br.com.fiap.postech.fastfood.adapter.controller

import br.com.fiap.postech.fastfood.adapter.presenter.*
import br.com.fiap.postech.fastfood.domain.usecase.checkout.WebHookCheckoutNaoReceberUseCase
import br.com.fiap.postech.fastfood.domain.usecase.checkout.WebHookCheckoutPagoUseCase
import br.com.fiap.postech.fastfood.domain.usecase.cliente.BuscarClientePorCPFUseCase
import br.com.fiap.postech.fastfood.domain.usecase.cliente.CadastrarClienteUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("checkouts")
class CheckoutController (
    private val webHookCheckoutPagoUseCase: WebHookCheckoutPagoUseCase,
    private val webHookCheckoutNaoReceberUseCase: WebHookCheckoutNaoReceberUseCase
) {

    @PutMapping("/{qrCodeId}/webhook/pagar")
    fun receberPagamentoPedido(@PathVariable qrCodeId: UUID): PedidoResponse {
        return webHookCheckoutPagoUseCase.executa(qrCodeId).toResponse()
    }

    @PutMapping("/{qrCodeId}/webhook/nao-receber")
    fun naoreceberPagamentoPedido(@PathVariable qrCodeId: UUID): PedidoResponse {
        return webHookCheckoutNaoReceberUseCase.executa(qrCodeId).toResponse()
    }

}