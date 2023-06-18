package br.com.fiap.postech.fastfood.adapter.outbound.configuration

import br.com.fiap.postech.fastfood.application.domain.services.ClienteServiceImpl
import br.com.fiap.postech.fastfood.application.ports.repositories.ClienteRepositoryPort
import br.com.fiap.postech.fastfood.application.ports.interfaces.ClienteServicePort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfiguration {

    @Bean
    fun clienteService(clienteRepositoryPort: ClienteRepositoryPort): ClienteServicePort {
        return ClienteServiceImpl(clienteRepositoryPort)
    }
}