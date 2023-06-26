package br.com.fiap.postech.fastfood.adapter.inbound

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
    fun cadastrarCliente(@RequestBody cliente: ClienteDTO) {
        clienteServicePort.cadastrar(cliente)
    }

    @GetMapping
    fun buscarCliente(@RequestParam cpf: String): ClienteDTO {
        return clienteServicePort.buscarClientePorCpf(cpf)
    }
}