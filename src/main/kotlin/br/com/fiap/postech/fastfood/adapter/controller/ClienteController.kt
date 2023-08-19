package br.com.fiap.postech.fastfood.adapter.controller

import br.com.fiap.postech.fastfood.adapter.presenter.ClienteRequest
import br.com.fiap.postech.fastfood.adapter.presenter.ClienteResponse
import br.com.fiap.postech.fastfood.adapter.presenter.toCliente
import br.com.fiap.postech.fastfood.adapter.presenter.toClienteResponse
import br.com.fiap.postech.fastfood.domain.usecase.cliente.BuscarClientePorCPFUseCase
import br.com.fiap.postech.fastfood.domain.usecase.cliente.CadastrarClienteUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("cliente")
class ClienteController (
    private val cadastrarClienteUseCase: CadastrarClienteUseCase,
    private val buscarClientePorCPFUseCase: BuscarClientePorCPFUseCase
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastrarCliente(@RequestBody cliente: ClienteRequest): ClienteResponse {
        return cadastrarClienteUseCase.executa(cliente.toCliente()).toClienteResponse()
    }

    @GetMapping
    fun buscarCliente(@RequestParam cpf: String): ClienteResponse {
        return buscarClientePorCPFUseCase.executa(cpf).toClienteResponse()
    }
}