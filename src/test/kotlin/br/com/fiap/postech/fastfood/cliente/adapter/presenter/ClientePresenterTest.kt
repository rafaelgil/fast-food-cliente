import br.com.fiap.postech.fastfood.cliente.adapter.presenter.ClienteAutenticado
import br.com.fiap.postech.fastfood.cliente.adapter.presenter.ClienteRequest
import br.com.fiap.postech.fastfood.cliente.adapter.presenter.ClienteResponse
import junit.framework.TestCase.assertEquals
import org.junit.jupiter.api.Test
import java.util.UUID

class ClientePresenterTest {

    @Test
    fun `precisaCriarInstanciaClienteRequest`() {
        val clienteRequest = ClienteRequest("", "", "")

        clienteRequest.cpf = "99999999999"
        clienteRequest.nome = "Joao"
        clienteRequest.email = "joao@email.com"

        assertEquals(clienteRequest.cpf, clienteRequest.cpf)
        assertEquals(clienteRequest.nome, clienteRequest.nome)
        assertEquals(clienteRequest.email, clienteRequest.email)
    }

    @Test
    fun `precisaCriarInstanciaClienteResponse`() {
        val clienteRequest = ClienteResponse(null, "", "", "")

        clienteRequest.id = UUID.randomUUID()
        clienteRequest.cpf = "99999999999"
        clienteRequest.nome = "Joao"
        clienteRequest.email = "joao@email.com"

        assertEquals(clienteRequest.id, clienteRequest.id)
        assertEquals(clienteRequest.cpf, clienteRequest.cpf)
        assertEquals(clienteRequest.nome, clienteRequest.nome)
        assertEquals(clienteRequest.email, clienteRequest.email)
    }

    @Test
    fun `precisaCriarInstanciaClienteAutenticado`() {
        val clienteAutenticado = ClienteAutenticado("", "",)

        clienteAutenticado.mensagem = "Clienteautenticado"
        clienteAutenticado.token = "123"

        assertEquals(clienteAutenticado.mensagem, clienteAutenticado.mensagem)
        assertEquals(clienteAutenticado.token, clienteAutenticado.token)
    }
}