package br.com.fiap.postech.fastfood.cliente.domain.usecase.cliente

import br.com.fiap.postech.fastfood.cliente.domain.entity.Cliente
import br.com.fiap.postech.fastfood.cliente.domain.repository.ClienteRepository
import br.com.fiap.postech.fastfood.cliente.domain.valueObjets.CPF
import br.com.fiap.postech.fastfood.cliente.domain.valueObjets.Email
import br.com.fiap.postech.fastfood.cliente.domain.valueObjets.Nome
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.assertj.core.api.Assertions.assertThat
import org.mockito.MockitoAnnotations
import java.util.*

class BuscarClientePorCPFUseCaseTest {

    @Mock
    private lateinit var clienteRepository: ClienteRepository

    @InjectMocks
    private lateinit var buscarClientePorCPFUseCase: BuscarClientePorCPFUseCase

    private val clienteId = UUID.randomUUID()
    private val clienteCpf = "12345678901"
    private val clienteNome = "John Doe"
    private val clienteEmail = "john.doe@example.com"
    private val cliente = Cliente(clienteId, CPF(clienteCpf), Nome(clienteNome), Email(clienteEmail))

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `deveBuscarClientePorCPFComSucesso`() {
        `when`(clienteRepository.buscarClientePorCpf(clienteCpf)).thenReturn(cliente)

        val result = buscarClientePorCPFUseCase.executa(clienteCpf)

        assertThat(result).isEqualTo(cliente)
    }

    @Test
    fun `deveLancarExcecaoQuandoClienteNaoEncontradoPorCPF`() {
        val cpfNaoCadastrado = "98765432109"
        `when`(clienteRepository.buscarClientePorCpf(cpfNaoCadastrado)).thenThrow(NoSuchElementException::class.java)

        val exception = org.junit.jupiter.api.assertThrows<NoSuchElementException> {
            buscarClientePorCPFUseCase.executa(cpfNaoCadastrado)
        }

        assertThat(exception).isInstanceOf(NoSuchElementException::class.java)
    }
}