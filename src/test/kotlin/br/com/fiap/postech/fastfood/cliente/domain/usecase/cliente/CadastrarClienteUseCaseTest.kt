package br.com.fiap.postech.fastfood.cliente.domain.usecase.cliente

import br.com.fiap.postech.fastfood.cliente.domain.entity.Cliente
import br.com.fiap.postech.fastfood.cliente.domain.exception.ViolatesUniqueConstraintException
import br.com.fiap.postech.fastfood.cliente.domain.repository.ClienteRepository
import br.com.fiap.postech.fastfood.cliente.domain.valueObjets.CPF
import br.com.fiap.postech.fastfood.cliente.domain.valueObjets.Email
import br.com.fiap.postech.fastfood.cliente.domain.valueObjets.Nome
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.assertj.core.api.Assertions.assertThat
import org.mockito.MockitoAnnotations
import java.util.*

class CadastrarClienteUseCaseTest {

    @Mock
    private lateinit var clienteRepository: ClienteRepository

    @InjectMocks
    private lateinit var cadastrarClienteUseCase: CadastrarClienteUseCase

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
    fun `deveCadastrarClienteComSucesso`() {
        `when`(clienteRepository.buscarCPFouEmailDuplicado(clienteCpf, clienteEmail)).thenReturn(false)
        `when`(clienteRepository.cadastrar(cliente)).thenReturn(cliente)

        val result = cadastrarClienteUseCase.executa(cliente)

        assertThat(result).isNotNull()

        verify(clienteRepository).buscarCPFouEmailDuplicado(clienteCpf, clienteEmail)
        verify(clienteRepository).cadastrar(cliente)
    }

    @Test
    fun `deveLancarExcecaoQuandoCadastrarClienteComCPFouEmailDuplicado`() {
        `when`(clienteRepository.buscarCPFouEmailDuplicado(clienteCpf, clienteEmail)).thenReturn(true)

        val exception = org.junit.jupiter.api.assertThrows<ViolatesUniqueConstraintException> {
            cadastrarClienteUseCase.executa(cliente)
        }

        assertThat(exception.message).isEqualTo("CPF ou E-mail já cadastrados!")

        verify(clienteRepository).buscarCPFouEmailDuplicado(clienteCpf, clienteEmail)
    }
}
