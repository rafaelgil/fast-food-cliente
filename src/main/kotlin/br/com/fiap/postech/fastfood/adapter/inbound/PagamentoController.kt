package br.com.fiap.postech.fastfood.adapter.inbound

import br.com.fiap.postech.fastfood.adapter.inbound.extension.toPagamentoDTO
import br.com.fiap.postech.fastfood.adapter.inbound.extension.toPagamentoResponse
import br.com.fiap.postech.fastfood.adapter.inbound.request.PagamentoRequest
import br.com.fiap.postech.fastfood.adapter.inbound.response.PagamentoResponse
import br.com.fiap.postech.fastfood.application.ports.interfaces.PagamentoServicePort
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("pagamento")
class PagamentoController(
    private var pagamentoServicePort: PagamentoServicePort
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastrar(@RequestBody pagamento: PagamentoRequest): PagamentoResponse? {

        return null// pagamentoServicePort.efetuaPagamento(pagamento.toPagamentoDTO()).toPagamentoResponse()
    }
}