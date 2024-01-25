package br.com.fiap.postech.fastfood.cliente.adapter.controller

import br.com.fiap.postech.fastfood.cliente.adapter.presenter.ClienteRequest
import br.com.fiap.postech.fastfood.cliente.domain.entity.Cliente
import br.com.fiap.postech.fastfood.cliente.domain.usecase.cliente.BuscarClientePorCPFUseCase
import br.com.fiap.postech.fastfood.cliente.domain.usecase.cliente.CadastrarClienteUseCase
import br.com.fiap.postech.fastfood.cliente.domain.valueObjets.CPF
import br.com.fiap.postech.fastfood.cliente.domain.valueObjets.Email
import br.com.fiap.postech.fastfood.cliente.domain.valueObjets.Nome
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.mockito.kotlin.any
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import java.lang.RuntimeException
import java.util.*

class ClienteControllerTest {
    @Mock
    private lateinit var cadastrarClienteUseCase: CadastrarClienteUseCase

    @Mock
    private lateinit var buscarClientePorCPFUseCase: BuscarClientePorCPFUseCase

    @InjectMocks
    private lateinit var clienteController: ClienteController

    private lateinit var mockMvc: MockMvc
    lateinit var openMocks: AutoCloseable

    @BeforeEach
    fun setup() {
        openMocks = MockitoAnnotations.openMocks(this)
        var clienteController = ClienteController(
                cadastrarClienteUseCase,
                buscarClientePorCPFUseCase
        )

        mockMvc = MockMvcBuilders.standaloneSetup(clienteController)
                .setControllerAdvice(ControllerAdvice())
                .build()
    }

    @Test
    fun `deveCadastrarUmClienteComSucesso`() {
        val request = clienteRequest("99999999999", "Joao", "email@email.com")
        val response = clienteResponse(UUID.randomUUID(), "99999999999", "Joao", "email@email.com")

        Mockito.`when`(cadastrarClienteUseCase.executa(any()))
                .thenReturn(response)

        mockMvc.perform(
                post("/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(request))
        )
                .andExpect(status().isCreated())
    }

    @Test
    fun `deveBuscarUmClienteExistenteComSucesso`() {
        val request = clienteRequest("99999999999", "Joao", "email@email.com")
        val response = clienteResponse(UUID.randomUUID(), "99999999999", "Joao", "email@email.com")

        Mockito.`when`(buscarClientePorCPFUseCase.executa(any()))
                .thenReturn(response)

        mockMvc.perform(
                get("/cliente?cpf=99999999999")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(request))
        )
                .andExpect(status().isOk)
    }

    @Test
    @Throws(java.lang.Exception::class)
    fun `deveGerarExcecaoQuandoCadastrarClienteComEmailInvalido`() {
        val request = clienteRequest("99999999999", "Joao", "email_invalido")

        mockMvc.perform(
                post("/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(request))
        )
                .andExpect(status().is4xxClientError)
                .andExpect(MockMvcResultMatchers.jsonPath("$.mensagem").value("E-mail deve ser válido"))
    }

    @Test
    @Throws(java.lang.Exception::class)
    fun `deveGerarExcecaoQuandoCadastrarClienteComEmailVazio`() {
        val request = clienteRequest("99999999999", "Joao", "")

        mockMvc.perform(
                post("/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(request))
        )
                .andExpect(status().is4xxClientError)
                .andExpect(MockMvcResultMatchers.jsonPath("$.mensagem").value("E-mail deve ser informado"))
    }

    @Test
    @Throws(java.lang.Exception::class)
    fun `deveGerarExcecaoQuandoCadastrarClienteComCpfInvalido`() {
        val request = clienteRequest("999", "Joao", "email@email.com")

        mockMvc.perform(
                post("/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(request))
        )
                .andExpect(status().is4xxClientError)
                .andExpect(MockMvcResultMatchers.jsonPath("$.mensagem").value("CPF deve ser válido"))
    }

    @Test
    @Throws(java.lang.Exception::class)
    fun `deveGerarExcecaoQuandoCadastrarClienteComCpfVazio`() {
        val request = clienteRequest("", "Joao", "email@email.com")

        mockMvc.perform(
                post("/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(request))
        )
                .andExpect(status().is4xxClientError)
                .andExpect(MockMvcResultMatchers.jsonPath("$.mensagem").value("CPF deve ser informado"))
    }

    @Test
    @Throws(java.lang.Exception::class)
    fun `deveGerarExcecaoQuandoCadastrarClienteComNomeVazio`() {
        val request = clienteRequest("99999999999", "", "email@email.com")

        mockMvc.perform(
                post("/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(request))
        )
                .andExpect(status().is4xxClientError)
                .andExpect(MockMvcResultMatchers.jsonPath("$.mensagem").value("Nome deve ser informado"))
    }
}

fun clienteRequest(
        cpf: String,
        nome: String,
        email: String
): ClienteRequest {
    return ClienteRequest(
            cpf = cpf,
            nome = nome,
            email = email
    )
}

fun clienteResponse(
        id: UUID,
        cpf: String,
        nome: String,
        email: String
): Cliente {
    return Cliente(
            id = id,
            cpf = CPF(cpf),
            nome = Nome(nome),
            email = Email(email)
    )
}

fun asJsonString(obj: Any?): String {
    try {
        return ObjectMapper().writeValueAsString(obj)
    } catch (e: java.lang.Exception) {
        throw RuntimeException(e)
    }
}