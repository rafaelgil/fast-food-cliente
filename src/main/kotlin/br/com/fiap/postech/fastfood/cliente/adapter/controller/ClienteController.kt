package br.com.fiap.postech.fastfood.cliente.adapter.controller

import br.com.fiap.postech.fastfood.cliente.adapter.presenter.*
import br.com.fiap.postech.fastfood.cliente.domain.usecase.cliente.AtualizarStatusClienteUseCase
import br.com.fiap.postech.fastfood.cliente.domain.usecase.cliente.BuscarClientePorCPFUseCase
import br.com.fiap.postech.fastfood.cliente.domain.usecase.cliente.BuscarClientePorIdUseCase
import br.com.fiap.postech.fastfood.cliente.domain.usecase.cliente.CadastrarClienteUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("cliente")
class ClienteController (
    private val cadastrarClienteUseCase: CadastrarClienteUseCase,
    private val buscarClientePorCPFUseCase: BuscarClientePorCPFUseCase,
    private val buscarClientePorIdUseCase: BuscarClientePorIdUseCase,
    private val atualizarStatusClienteUseCase: AtualizarStatusClienteUseCase
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

    @GetMapping("/{id}")
    fun buscarCliente(@PathVariable id: UUID): ClienteResponse {
        return buscarClientePorIdUseCase.executa(id).toClienteResponse()
    }

    @PutMapping("/{id}/inativar")
    fun inativarCliente(@PathVariable id: UUID): ClienteResponse {
        return atualizarStatusClienteUseCase.executa(id, "INATIVO").toClienteResponse()
    }
}