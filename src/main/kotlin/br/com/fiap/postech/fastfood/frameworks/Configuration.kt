package br.com.fiap.postech.fastfood.frameworks

import br.com.fiap.postech.fastfood.adapter.gateway.PedidoRepositoryImpl
import br.com.fiap.postech.fastfood.adapter.gateway.ProdutoRepositoryImpl
import br.com.fiap.postech.fastfood.adapter.gateway.jpa.PedidoRepositoryJpa
import br.com.fiap.postech.fastfood.adapter.gateway.jpa.ProdutoRepositoryJpa
import br.com.fiap.postech.fastfood.application.domain.services.*
import br.com.fiap.postech.fastfood.application.ports.interfaces.CheckoutServicePort
import br.com.fiap.postech.fastfood.application.ports.interfaces.ClienteServicePort
import br.com.fiap.postech.fastfood.application.ports.interfaces.PagamentoServicePort
import br.com.fiap.postech.fastfood.application.ports.interfaces.ProdutoServicePort
import br.com.fiap.postech.fastfood.application.ports.repositories.*
import br.com.fiap.postech.fastfood.domain.repository.PedidoRepository
import br.com.fiap.postech.fastfood.domain.repository.ProdutoRepository
import br.com.fiap.postech.fastfood.domain.usecase.pedido.ListarPedidosUseCase
import br.com.fiap.postech.fastfood.domain.usecase.produto.AtualzarProdutoUseCase
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
    fun cadastrarProdutoUseCase(produtoRepository: ProdutoRepository): CadastrarProdutoUseCase {
        return CadastrarProdutoUseCase(produtoRepository)
    }

    @Bean
    fun atualzarProdutoUseCase(produtoRepository: ProdutoRepository): AtualzarProdutoUseCase {
        return AtualzarProdutoUseCase(produtoRepository)
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
    fun clienteService(clienteRepositoryPort: ClienteRepositoryPort): ClienteServicePort {
        return ClienteServiceImpl(clienteRepositoryPort)
    }

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