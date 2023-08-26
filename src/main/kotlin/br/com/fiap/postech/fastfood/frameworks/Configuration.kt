package br.com.fiap.postech.fastfood.frameworks

import br.com.fiap.postech.fastfood.adapter.gateway.*
import br.com.fiap.postech.fastfood.adapter.gateway.jpa.*
import br.com.fiap.postech.fastfood.domain.repository.*
import br.com.fiap.postech.fastfood.domain.usecase.checkout.IniciarCheckoutUseCase
import br.com.fiap.postech.fastfood.domain.usecase.checkout.WebHookCheckoutPagoUseCase
import br.com.fiap.postech.fastfood.domain.usecase.cliente.BuscarClientePorCPFUseCase
import br.com.fiap.postech.fastfood.domain.usecase.cliente.CadastrarClienteUseCase
import br.com.fiap.postech.fastfood.domain.usecase.pagamento.GerarPagamentoQrCodeUseCase
import br.com.fiap.postech.fastfood.domain.usecase.pagamento.MudarStatusPagamentoUseCase
import br.com.fiap.postech.fastfood.domain.usecase.pedido.*
import br.com.fiap.postech.fastfood.domain.usecase.produto.AtualizarProdutoUseCase
import br.com.fiap.postech.fastfood.domain.usecase.produto.BuscarProdutoPorCategoriaUseCase
import br.com.fiap.postech.fastfood.domain.usecase.produto.CadastrarProdutoUseCase
import br.com.fiap.postech.fastfood.domain.usecase.produto.RemoverProdutoUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Configuration {

    @Bean
    fun produtoRepository(produtoRepositoryJpa: ProdutoRepositoryJpa): ProdutoRepository {
        return ProdutoRepositoryImpl(produtoRepositoryJpa)
    }

    @Bean
    fun pedidoRepository(pedidoRepositoryJpa: PedidoRepositoryJpa): PedidoRepository {
        return PedidoRepositoryImpl(pedidoRepositoryJpa)
    }

    @Bean
    fun clienteRepository(clienteRepositoryJpa: ClienteRepositoryJpa): ClienteRepository {
        return ClienteRepositoryImpl(clienteRepositoryJpa)
    }

    @Bean
    fun checkoutRepository(checkoutRepositoryJpa: CheckoutRepositoryJpa): CheckoutRepository{
        return CheckoutRepositoryImpl(checkoutRepositoryJpa)
    }

    @Bean
    fun pagamentoRepository(
        pagamentoRepositoryJpa: PagamentoRepositoryJpa
    ): PagamentoRepository {
        return PagamentoRepositoryImpl(pagamentoRepositoryJpa)
    }


    @Bean
    fun cadastrarProdutoUseCase(produtoRepository: ProdutoRepository): CadastrarProdutoUseCase {
        return CadastrarProdutoUseCase(produtoRepository)
    }

    @Bean
    fun atualizarProdutoUseCase(produtoRepository: ProdutoRepository): AtualizarProdutoUseCase {
        return AtualizarProdutoUseCase(produtoRepository)
    }

    @Bean
    fun removerProdutoUseCase(produtoRepository: ProdutoRepository): RemoverProdutoUseCase {
        return RemoverProdutoUseCase(produtoRepository)
    }

    @Bean
    fun buscarProdutoPorCategoriaUseCase(produtoRepository: ProdutoRepository): BuscarProdutoPorCategoriaUseCase {
        return BuscarProdutoPorCategoriaUseCase(produtoRepository)
    }

    @Bean
    fun listarPedidosUseCase(pedidoRepository: PedidoRepository): ListarPedidoUseCase {
        return ListarPedidoUseCase(pedidoRepository)
    }

    @Bean
    fun cadastrarPedidoUseCase(pedidoRepository: PedidoRepository,
                               produtoRepository: ProdutoRepository,
                               clienteRepository: ClienteRepository) =
        CadastrarPedidoUseCase(pedidoRepository,
            produtoRepository, clienteRepository)

    @Bean
    fun cadastrarClienteUseCase(clienteRepository: ClienteRepository): CadastrarClienteUseCase {
        return CadastrarClienteUseCase(clienteRepository)
    }

    @Bean
    fun buscarClientePorCPFUseCase(clienteRepository: ClienteRepository): BuscarClientePorCPFUseCase {
        return BuscarClientePorCPFUseCase(clienteRepository)
    }

    @Bean
    fun gerarPagamentoQrCodeUseCase(): GerarPagamentoQrCodeUseCase {
        return GerarPagamentoQrCodeUseCase()
    }

    @Bean
    fun mudarStatusPedidoUseCase(pedidoRepository: PedidoRepository): MudarStatusPedidoUseCase{
        return MudarStatusPedidoUseCase(pedidoRepository)
    }

    @Bean
    fun iniciarCheckoutUseCase(gerarPagamentoQrCodeUseCase: GerarPagamentoQrCodeUseCase,
         mudarStatusPedidoUseCase: MudarStatusPedidoUseCase,
         checkoutRepository: CheckoutRepository,
         cadastrarPedidoUseCase: CadastrarPedidoUseCase
    ): IniciarCheckoutUseCase {
        return IniciarCheckoutUseCase(gerarPagamentoQrCodeUseCase, mudarStatusPedidoUseCase, checkoutRepository, cadastrarPedidoUseCase)
    }

    @Bean
    fun mudarStatusPagamentoUseCase(
        pagamentoRepository: PagamentoRepository
    ): MudarStatusPagamentoUseCase {
        return MudarStatusPagamentoUseCase(pagamentoRepository)
    }

    @Bean
    fun webHookCheckoutPagoUseCase(
        mudarStatusPagamentoUseCase: MudarStatusPagamentoUseCase,
        mudarStatusPedidoUseCase: MudarStatusPedidoUseCase,
        checkoutRepository: CheckoutRepository
    ): WebHookCheckoutPagoUseCase {
        return WebHookCheckoutPagoUseCase(mudarStatusPagamentoUseCase, mudarStatusPedidoUseCase, checkoutRepository)
    }

    @Bean
    fun listarTodosPedidosUseCase(
        pedidoRepository: PedidoRepository
    ): ListarTodosPedidosUseCase {
        return ListarTodosPedidosUseCase(pedidoRepository)
    }
}