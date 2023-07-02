package br.com.fiap.postech.fastfood.adapter.outbound.configuration

import br.com.fiap.postech.fastfood.application.domain.services.*
import br.com.fiap.postech.fastfood.application.ports.interfaces.CheckoutServicePort
import br.com.fiap.postech.fastfood.application.ports.interfaces.ClienteServicePort
import br.com.fiap.postech.fastfood.application.ports.interfaces.PagamentoServicePort
import br.com.fiap.postech.fastfood.application.ports.interfaces.ProdutoServicePort
import br.com.fiap.postech.fastfood.application.ports.repositories.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfiguration {

    @Bean
    fun clienteService(clienteRepositoryPort: ClienteRepositoryPort): ClienteServicePort {
        return ClienteServiceImpl(clienteRepositoryPort)
    }

    @Bean
    fun produtoService(produtoRepositoryPort: ProdutoRepositoryPort): ProdutoServicePort {
        return ProdutoServiceImpl(produtoRepositoryPort)
    }

    @Bean
    fun pedidoService(pedidoRepositoryPort: PedidoRepositoryPort): PedidoServiceImpl {
        return PedidoServiceImpl(pedidoRepositoryPort)
    }


    @Bean
    fun checkoutService(checkoutRepositoryPort: CheckoutRepositoryPort, pedidoRepositoryPort: PedidoRepositoryPort, pagamentoServicePort: PagamentoServicePort): CheckoutServicePort {
        return CheckoutServiceImpl(checkoutRepositoryPort, pedidoRepositoryPort, pagamentoServicePort)
    }

    @Bean
    fun pagamentoService(pagamentoRepositoryPort: PagamentoRepositoryPort): PagamentoServicePort {
        return PagamentoServiceImpl(pagamentoRepositoryPort)
    }
}