package br.com.fiap.postech.fastfood.adapter.inbound

import br.com.fiap.postech.fastfood.adapter.inbound.extension.toClienteDTO
import br.com.fiap.postech.fastfood.adapter.inbound.extension.toClienteResponse
import br.com.fiap.postech.fastfood.adapter.inbound.request.ClienteRequest
import br.com.fiap.postech.fastfood.adapter.inbound.response.ClienteResponse
import br.com.fiap.postech.fastfood.application.domain.dtos.ClienteDTO
import br.com.fiap.postech.fastfood.application.ports.interfaces.ClienteServicePort
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("cliente")
class ClienteController (
    private val clienteServicePort: ClienteServicePort
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastrarCliente(@RequestBody cliente: ClienteRequest): ClienteResponse {
        return clienteServicePort.cadastrar(cliente.toClienteDTO()).toClienteResponse()
    }

    @GetMapping
    fun buscarCliente(@RequestParam cpf: String): ClienteResponse {
        return clienteServicePort.buscarClientePorCpf(cpf).toClienteResponse()
    }
}