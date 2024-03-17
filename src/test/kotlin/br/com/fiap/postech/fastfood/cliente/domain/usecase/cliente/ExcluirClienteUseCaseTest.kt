import br.com.fiap.postech.fastfood.cliente.domain.entity.Cliente
import br.com.fiap.postech.fastfood.cliente.domain.exception.ClienteNotFoundException
import br.com.fiap.postech.fastfood.cliente.domain.exception.NotFoundEntityException
import br.com.fiap.postech.fastfood.cliente.domain.exception.ViolatesUniqueConstraintException
import br.com.fiap.postech.fastfood.cliente.domain.repository.ClienteRepository
import br.com.fiap.postech.fastfood.cliente.domain.usecase.cliente.ExcluirClienteUseCase
import br.com.fiap.postech.fastfood.cliente.domain.valueObjets.CPF
import br.com.fiap.postech.fastfood.cliente.domain.valueObjets.Email
import br.com.fiap.postech.fastfood.cliente.domain.valueObjets.Nome
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
class ExcluirClienteUseCaseTest {

    @Mock
    private lateinit var clienteRepository: ClienteRepository

    @InjectMocks
    private lateinit var excluirClienteUseCase: ExcluirClienteUseCase

    private val clienteId = UUID.randomUUID()
    private val clienteCpf = "12345678901"
    private val clienteNome = "Joao"
    private val clienteEmail = "joao@email.com"
    private val cliente = Cliente(clienteId, CPF(clienteCpf), Nome(clienteNome), Email(clienteEmail))

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `deveLancarExcecaoQuandoClienteNaoEncontrado`() {
        val exception = org.junit.jupiter.api.assertThrows<ClienteNotFoundException> {
            excluirClienteUseCase.executa(cliente)
        }

        Assertions.assertThat(exception.message).isEqualTo("Cliente não encontrado.")
    }
}