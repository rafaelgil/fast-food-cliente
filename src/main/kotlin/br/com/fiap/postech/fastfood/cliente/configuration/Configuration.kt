package br.com.fiap.postech.fastfood.cliente.configuration

import br.com.fiap.postech.fastfood.adapter.gateway.events.producer.SQSClienteProducer
import br.com.fiap.postech.fastfood.cliente.adapter.gateway.*
import br.com.fiap.postech.fastfood.cliente.adapter.gateway.jpa.*
import br.com.fiap.postech.fastfood.cliente.domain.repository.*
import br.com.fiap.postech.fastfood.cliente.domain.usecase.cliente.AtualizarStatusClienteUseCase
import br.com.fiap.postech.fastfood.cliente.domain.usecase.cliente.BuscarClientePorCPFUseCase
import br.com.fiap.postech.fastfood.cliente.domain.usecase.cliente.BuscarClientePorIdUseCase
import br.com.fiap.postech.fastfood.cliente.domain.usecase.cliente.CadastrarClienteUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate


@Configuration
class Configuration {

    @Bean
    fun clienteRepository(clienteRepositoryJpa: ClienteRepositoryJpa): ClienteRepository {
        return ClienteRepositoryImpl(clienteRepositoryJpa)
    }

    @Bean
    fun cadastrarClienteUseCase(clienteRepository: ClienteRepository): CadastrarClienteUseCase {
        return CadastrarClienteUseCase(clienteRepository)
    }

    @Bean
    fun atualizarClienteUseCase(clienteRepository: ClienteRepository, sqsClienteProducer: SQSClienteProducer): AtualizarStatusClienteUseCase {
        return AtualizarStatusClienteUseCase(clienteRepository, sqsClienteProducer)
    }

    @Bean
    fun buscarClientePorCPFUseCase(clienteRepository: ClienteRepository): BuscarClientePorCPFUseCase {
        return BuscarClientePorCPFUseCase(clienteRepository)
    }

    @Bean
    fun buscarClientePorIdUseCase(clienteRepository: ClienteRepository): BuscarClientePorIdUseCase {
        return BuscarClientePorIdUseCase(clienteRepository)
    }

    @Bean
    fun restTemplate(): RestTemplate {
        return RestTemplate()
    }
}