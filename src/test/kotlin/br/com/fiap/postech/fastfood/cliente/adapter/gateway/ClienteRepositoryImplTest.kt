package br.com.fiap.postech.fastfood.cliente.adapter.gateway

import br.com.fiap.postech.fastfood.cliente.adapter.gateway.jpa.ClienteRepositoryJpa
import br.com.fiap.postech.fastfood.cliente.adapter.presenter.toClienteScheme
import br.com.fiap.postech.fastfood.cliente.domain.entity.Cliente
import br.com.fiap.postech.fastfood.cliente.domain.exception.ClienteNotFoundException
import br.com.fiap.postech.fastfood.cliente.domain.valueObjets.*
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.whenever
import java.util.*

class ClienteRepositoryImplTest {
    @Mock
    private lateinit var clienteRepositoryJpa: ClienteRepositoryJpa

    @InjectMocks
    private lateinit var clienteRepositoryImpl: ClienteRepositoryImpl

    private val clienteId = UUID.randomUUID()
    private val clienteCpf = "12345678901"
    private val clienteNome = "Joa"
    private val clienteEmail = "joao@email.com"
    private val cliente = Cliente(clienteId, CPF( clienteCpf), Nome(clienteNome), Email(clienteEmail), "ATIVO",
        Endereco("Rua 1"), Telefone("11999999999"))

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `deveBuscarClientePorIdComSucesso`() {
        whenever(clienteRepositoryJpa.findById(clienteId)).thenReturn(Optional.of(cliente.toClienteScheme()))

        val result = clienteRepositoryImpl.buscarPorId(clienteId)

        assertThat(result.nome.toString()).isNotEmpty()
        assertEquals(cliente.nome.toString(), result.nome.toString())
        assertEquals(cliente.email.toString(), result.email.toString())
        assertEquals(cliente.cpf.toString(), result.cpf.toString())
    }

    @Test
    fun `deveBuscarClientePorCpfComSucesso`() {
        whenever(clienteRepositoryJpa.findByCpf(clienteCpf)).thenReturn(cliente.toClienteScheme())

        val result = clienteRepositoryImpl.buscarClientePorCpf(clienteCpf)

        assertThat(result.nome.toString()).isNotEmpty()
        assertEquals(cliente.nome.toString(), result.nome.toString())
        assertEquals(cliente.email.toString(), result.email.toString())
        assertEquals(cliente.cpf.toString(), result.cpf.toString())
    }

    @Test
    fun `deveVerificarCpfOuEmailDuplicadoComSucesso`() {
        val cpfDuplicado = "98765432109"
        val emailDuplicado = "email_duplicado@email.com"
        whenever(clienteRepositoryJpa.existsCpfOrEmail(clienteCpf, clienteEmail)).thenReturn(false)
        whenever(clienteRepositoryJpa.existsCpfOrEmail(cpfDuplicado, emailDuplicado)).thenReturn(true)

        val result1 = clienteRepositoryImpl.buscarCPFouEmailDuplicado(clienteCpf, clienteEmail)
        val result2 = clienteRepositoryImpl.buscarCPFouEmailDuplicado(cpfDuplicado, emailDuplicado)

        assertEquals(false, result1)
        assertEquals(true, result2)
    }

    @Test
    fun `deveRetornarNullQuandoBuscarClientePorIdInexistente`() {
        val nonExistingId = UUID.randomUUID()
        whenever(clienteRepositoryJpa.findById(nonExistingId)).thenReturn(Optional.empty())

        Assertions.assertThatThrownBy {
            clienteRepositoryImpl.buscarPorId(nonExistingId)
        }.isInstanceOf(ClienteNotFoundException::class.java)
         .hasMessage("Cliente ${nonExistingId} não encontrado")

    }

}