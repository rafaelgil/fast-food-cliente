package br.com.fiap.postech.fastfood.adapter.controller

import br.com.fiap.postech.fastfood.adapter.inbound.extension.toPedidoDTO
//import br.com.fiap.postech.fastfood.adapter.inbound.extension.toPedidoResponse
import br.com.fiap.postech.fastfood.adapter.inbound.extension.toProdutoResponse
import br.com.fiap.postech.fastfood.adapter.inbound.request.PedidoRequest
import br.com.fiap.postech.fastfood.adapter.presenter.PedidoResponse
import br.com.fiap.postech.fastfood.adapter.presenter.toPedidoResponse
import br.com.fiap.postech.fastfood.application.domain.dtos.PedidoDTO
import br.com.fiap.postech.fastfood.application.domain.dtos.ProdutoDTO
import br.com.fiap.postech.fastfood.application.ports.interfaces.PedidoServicePort
import br.com.fiap.postech.fastfood.domain.usecase.pedido.ListarPedidosUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("pedido")
class PedidoController (
//    private val pedidoServicePort: PedidoServicePort,
    private val listarPedidosUseCase: ListarPedidosUseCase
) {
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    fun cadastrar(@RequestBody pedidoRequest: PedidoRequest): PedidoResponse {
//        var pedido = pedidoServicePort.cadastrar(pedidoRequest.toPedidoDTO()).toPedidoResponse()
//        return pedido
//    }

//    @PutMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    fun atualizar(@PathVariable id: UUID, @RequestBody pedidoRequest: PedidoRequest): PedidoResponse {
//        var pedido = pedidoServicePort.atualizar(id, pedidoRequest.toPedidoDTO()).toPedidoResponse()
//        return pedido
//    }

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    fun listar(): List<PedidoResponse> {
        return listarPedidosUseCase.execute().map { it.toPedidoResponse() }
    }
}