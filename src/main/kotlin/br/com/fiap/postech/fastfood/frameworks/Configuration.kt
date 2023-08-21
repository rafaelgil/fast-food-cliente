package br.com.fiap.postech.fastfood.frameworks

import br.com.fiap.postech.fastfood.adapter.gateway.CheckoutRepositoryImpl
import br.com.fiap.postech.fastfood.adapter.gateway.ClienteRepositoryImpl
import br.com.fiap.postech.fastfood.adapter.gateway.PedidoRepositoryImpl
import br.com.fiap.postech.fastfood.adapter.gateway.ProdutoRepositoryImpl
import br.com.fiap.postech.fastfood.adapter.gateway.jpa.CheckoutRepositoryJpa
import br.com.fiap.postech.fastfood.adapter.gateway.jpa.ClienteRepositoryJpa
import br.com.fiap.postech.fastfood.adapter.gateway.jpa.PedidoRepositoryJpa
import br.com.fiap.postech.fastfood.adapter.gateway.jpa.ProdutoRepositoryJpa
import br.com.fiap.postech.fastfood.domain.repository.CheckoutRepository
import br.com.fiap.postech.fastfood.domain.repository.ClienteRepository
import br.com.fiap.postech.fastfood.domain.repository.PedidoRepository
import br.com.fiap.postech.fastfood.domain.repository.ProdutoRepository
import br.com.fiap.postech.fastfood.domain.usecase.checkout.IniciarCheckoutUseCase
import br.com.fiap.postech.fastfood.domain.usecase.cliente.BuscarClientePorCPFUseCase
import br.com.fiap.postech.fastfood.domain.usecase.cliente.CadastrarClienteUseCase
import br.com.fiap.postech.fastfood.domain.usecase.pagamento.GerarPagamentoQrCodeUseCase
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
    fun listarPedidosUseCase(pedidoRepository: PedidoRepository): ListarPedidosUseCase {
        return ListarPedidosUseCase(pedidoRepository)
    }

    @Bean
    fun cadastrarPedidoUseCase(pedidoRepository: PedidoRepository,
                               produtoRepository: ProdutoRepository,
                               clienteRepository: ClienteRepository) =
        CadastrarPedidoUseCase(pedidoRepository,
            produtoRepository, clienteRepository)

    @Bean
    fun adicionarItemPedidoUseCase(pedidoRepository: PedidoRepository,
                               produtoRepository: ProdutoRepository) =
        AdicionarItemPedidoUseCase(pedidoRepository,
            produtoRepository)

    @Bean
    fun removerItemPedidoUseCase(pedidoRepository: PedidoRepository,
                                   produtoRepository: ProdutoRepository) =
        RemoverItemPedidoUseCase(pedidoRepository,
            produtoRepository)

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
         checkoutRepository: CheckoutRepository
    ): IniciarCheckoutUseCase {
        return IniciarCheckoutUseCase(gerarPagamentoQrCodeUseCase, mudarStatusPedidoUseCase, checkoutRepository)
    }

//    @Bean
//    fun clienteService(clienteRepositoryPort: ClienteRepositoryPort): ClienteServicePort {
//        return ClienteServiceImpl(clienteRepositoryPort)
//    }

//    @Bean
//    fun produtoService(produtoRepositoryPort: ProdutoRepositoryPort): ProdutoServicePort {
//        return ProdutoServiceImpl(produtoRepositoryPort)
//    }
//
//    @Bean
//    fun pedidoService(pedidoRepositoryPort: PedidoRepositoryPort): PedidoServiceImpl {
//        return PedidoServiceImpl(pedidoRepositoryPort)
//    }
//
//
//    @Bean
//    fun checkoutService(checkoutRepositoryPort: CheckoutRepositoryPort, pedidoRepositoryPort: PedidoRepositoryPort, pagamentoServicePort: PagamentoServicePort): CheckoutServicePort {
//        return CheckoutServiceImpl(checkoutRepositoryPort, pedidoRepositoryPort, pagamentoServicePort)
//    }
//
//    @Bean
//    fun pagamentoService(pagamentoRepositoryPort: PagamentoRepositoryPort): PagamentoServicePort {
//        return PagamentoServiceImpl(pagamentoRepositoryPort)
//    }
}