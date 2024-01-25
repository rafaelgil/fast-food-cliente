import br.com.fiap.postech.fastfood.cliente.adapter.gateway.jpa.ClienteRepositoryJpa
import br.com.fiap.postech.fastfood.cliente.configuration.Configuration
import br.com.fiap.postech.fastfood.cliente.domain.repository.ClienteRepository
import junit.framework.TestCase.assertNotNull
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class ConfigurationTest {

    @Test
    fun `deveCriarOBeanclienteRepository`() {
        val configuration = Configuration()

        val clienteRepository = configuration.clienteRepository(Mockito.mock(ClienteRepositoryJpa::class.java))

        assertNotNull(clienteRepository)
    }

    @Test
    fun `deveCriarOBeancadastrarClienteUseCase`() {
        val configuration = Configuration()

        val clienteRepository = Mockito.mock(ClienteRepository::class.java)

        val cadastrarClienteUseCase = configuration.cadastrarClienteUseCase(clienteRepository)

        assertNotNull(cadastrarClienteUseCase)
    }

    @Test
    fun `deveCriarOBeanbuscarClientePorCPFUseCase`() {
        val configuration = Configuration()
        val clienteRepository = Mockito.mock(ClienteRepository::class.java)

        val buscarClientePorCPFUseCase = configuration.buscarClientePorCPFUseCase(clienteRepository)

        assertNotNull(buscarClientePorCPFUseCase)
    }

    @Test
    fun `deveCriarOBeanrestTemplate`() {
        val configuration = Configuration()

        val restTemplate = configuration.restTemplate()

        assertNotNull(restTemplate)
    }
}
