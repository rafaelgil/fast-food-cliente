package br.com.fiap.postech.fastfood.adapter.inbound

import br.com.fiap.postech.fastfood.adapter.inbound.extension.toCheckoutDTO
import br.com.fiap.postech.fastfood.adapter.inbound.extension.toCheckoutResponse
import br.com.fiap.postech.fastfood.adapter.inbound.request.CheckoutRequest
import br.com.fiap.postech.fastfood.adapter.inbound.response.CheckoutResponse
import br.com.fiap.postech.fastfood.application.domain.dtos.CheckoutDTO
import br.com.fiap.postech.fastfood.application.ports.interfaces.CheckoutServicePort
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("checkout")
class CheckoutController (
    private val checkoutServicePort: CheckoutServicePort
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun enviaParaFila(@RequestBody checkoutRequest: CheckoutRequest): CheckoutResponse {
        return checkoutServicePort.enviaParaFila(checkoutRequest.toCheckoutDTO()).toCheckoutResponse()
    }
}