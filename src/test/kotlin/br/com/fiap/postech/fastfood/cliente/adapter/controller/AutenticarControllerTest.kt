import br.com.fiap.postech.fastfood.cliente.adapter.controller.AutenticarController
import br.com.fiap.postech.fastfood.cliente.adapter.controller.ErrorResponse
import br.com.fiap.postech.fastfood.cliente.adapter.controller.clienteResponse
import br.com.fiap.postech.fastfood.cliente.domain.exception.ClienteNotFoundException
import br.com.fiap.postech.fastfood.cliente.domain.usecase.cliente.BuscarClientePorCPFUseCase
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import java.util.*

class AutenticarControllerTest {

    @Mock
    private lateinit var buscarClientePorCPFUseCase: BuscarClientePorCPFUseCase

    @InjectMocks
    private lateinit var autenticarController: AutenticarController

    private lateinit var mockMvc: MockMvc

    @BeforeEach
    fun setup() {
        MockitoAnnotations.openMocks(this).close()
        mockMvc = MockMvcBuilders.standaloneSetup(autenticarController)
                .build()
    }

    @Test
    @Throws(java.lang.Exception::class)
    fun `deveAutenticarUmUsuarioExistente`() {
        val cpfInexistente = "99999999991"

        val response = clienteResponse(UUID.randomUUID(), "99999999999", "Joao", "email@email.com", "Endereco", "99999999999")

        Mockito.`when`(buscarClientePorCPFUseCase.executa(any()))
                .thenReturn(response)

        mockMvc.perform(
                get("/autenticar?cpf=$cpfInexistente")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk)
    }
}