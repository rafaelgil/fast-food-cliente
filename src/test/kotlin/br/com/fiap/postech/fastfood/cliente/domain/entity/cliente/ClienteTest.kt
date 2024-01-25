import br.com.fiap.postech.fastfood.cliente.domain.entity.Cliente
import br.com.fiap.postech.fastfood.cliente.domain.valueObjets.CPF
import br.com.fiap.postech.fastfood.cliente.domain.valueObjets.Email
import br.com.fiap.postech.fastfood.cliente.domain.valueObjets.Nome
import junit.framework.TestCase.assertEquals
import org.junit.jupiter.api.Test
import java.util.UUID

class ClienteTest {

    @Test
    fun `deveSetarAPropriedadeId`() {
        val cliente = Cliente()

        cliente.id = UUID.randomUUID()

        assertEquals(cliente.id.toString(), cliente.id.toString())
    }

    @Test
    fun `deveSetarAPropriedadeCpf`() {
        val cliente = Cliente()

        cliente.cpf = CPF("12345678901")

        assertEquals(CPF("12345678901").toString(), cliente.cpf.toString())
    }

    @Test
    fun `deveSetarAPropriedadeNome`() {
        val cliente = Cliente()

        cliente.nome = Nome("Joao")

        assertEquals(Nome("Joao").toString(), cliente.nome.toString())
    }

    @Test
    fun `deveSetarAPropriedadeEmail`() {
        val cliente = Cliente()

        cliente.email = Email("joao@email.com")

        assertEquals(Email("joao@email.com").toString(), cliente.email.toString())
    }
}
