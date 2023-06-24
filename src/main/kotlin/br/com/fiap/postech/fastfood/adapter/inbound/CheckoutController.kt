package br.com.fiap.postech.fastfood.adapter.inbound

import br.com.fiap.postech.fastfood.application.domain.dtos.CheckoutDTO
import br.com.fiap.postech.fastfood.application.domain.dtos.ClienteDTO
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
    fun enviaParaFila(@RequestBody checkout: CheckoutDTO): CheckoutDTO {
        var checkoutSended = checkoutServicePort.enviaParaFila(checkout)
        return checkoutSended
    }
}