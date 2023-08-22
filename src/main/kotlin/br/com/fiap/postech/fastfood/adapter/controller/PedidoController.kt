package br.com.fiap.postech.fastfood.adapter.controller


import br.com.fiap.postech.fastfood.adapter.presenter.*
import br.com.fiap.postech.fastfood.domain.usecase.checkout.IniciarCheckoutUseCase
import br.com.fiap.postech.fastfood.domain.usecase.pedido.*
import br.com.fiap.postech.fastfood.domain.valueObjets.StatusPedido
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("pedidos")
class PedidoController (
    private val listarPedidosUseCase: ListarPedidosUseCase,
    private val cadastrarPedidoUseCase: CadastrarPedidoUseCase,
    private val adicionarItemPedidoUseCase: AdicionarItemPedidoUseCase,
    private val removerItemPedidoUseCase: RemoverItemPedidoUseCase,
    private val iniciarCheckoutUseCase: IniciarCheckoutUseCase,
    private val mudarStatusPedidoUseCase: MudarStatusPedidoUseCase
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastrar(@RequestBody pedidoRequest: PedidoRequest) =
        cadastrarPedidoUseCase.executa(pedidoRequest.toPedido()).toResponse()

    @PatchMapping("/{id}/adicionar-item")
    @ResponseStatus(HttpStatus.OK)
    fun adicionarItem(@PathVariable id: UUID, @RequestBody itemPedidoRequest: ItemPedidoRequest) =
        adicionarItemPedidoUseCase.executa(id, itemPedidoRequest.toItem()).toResponse()

    @PatchMapping("/{id}/remover-item")
    @ResponseStatus(HttpStatus.OK)
    fun removerItem(@PathVariable id: UUID, @RequestBody itemPedidoRequest: ItemPedidoRequest) =
        removerItemPedidoUseCase.executa(id, itemPedidoRequest.toItem()).toResponse()

    @GetMapping("/{id}")
    fun listar(@PathVariable id: UUID): PedidoResponse {
        return listarPedidosUseCase.execute(id).toResponse()
    }

    @PutMapping("/{id}/finalizar")
    fun finalizarPedido(@PathVariable id: UUID) =
        iniciarCheckoutUseCase.executa(id).toResponse()

    @PutMapping("/{id}/entregar")
    fun entregar(@PathVariable id: UUID) =
        mudarStatusPedidoUseCase.executa(id, StatusPedido.EM_ENTREGA).toResponse()

    @PutMapping("/{id}/confirmar-entrega")
    fun confirmarEntrega(@PathVariable id: UUID) =
        mudarStatusPedidoUseCase.executa(id, StatusPedido.FINALIZADO).toResponse()
}