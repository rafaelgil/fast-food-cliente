package br.com.fiap.postech.fastfood.adapter.inbound

import br.com.fiap.postech.fastfood.application.domain.dtos.ClienteDTO
import br.com.fiap.postech.fastfood.application.ports.interfaces.ClienteServicePort
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("produto")
class ProdutoController (
    private val clienteServicePort: ClienteServicePort
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastrarCliente(@RequestBody cliente: ClienteDTO) {
        clienteServicePort.cadastrar(cliente)
    }
}