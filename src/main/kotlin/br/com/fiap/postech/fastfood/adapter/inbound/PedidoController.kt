package br.com.fiap.postech.fastfood.adapter.inbound

import br.com.fiap.postech.fastfood.application.domain.dtos.PedidoDTO
import br.com.fiap.postech.fastfood.application.domain.dtos.ProdutoDTO
import br.com.fiap.postech.fastfood.application.ports.interfaces.PedidoServicePort
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("pedido")
class PedidoController (
    private val pedidoServicePort: PedidoServicePort
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastrar(@RequestBody pedido: PedidoDTO) {
        pedidoServicePort.cadastrar(pedido)
    }

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    fun listar(): List<PedidoDTO> {
        return pedidoServicePort.listar()
    }
}