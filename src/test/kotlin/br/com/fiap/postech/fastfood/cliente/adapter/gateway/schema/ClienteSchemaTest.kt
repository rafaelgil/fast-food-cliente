import br.com.fiap.postech.fastfood.cliente.adapter.gateway.schema.ClienteSchema
import junit.framework.TestCase.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

class ClienteSchemaTest {

    @Test
    fun `deveSetarAPropriedadeId`() {
        val clienteSchema = ClienteSchema(null, "99999999999", "João", "email@email.com")

        clienteSchema.id = UUID.randomUUID()

        assertEquals(clienteSchema.id, clienteSchema.id)
    }

    @Test
    fun `deveSetarAPropriedadeCpf`() {
        val clienteSchema = ClienteSchema(null, "99999999999", "João", "email@email.com")

        clienteSchema.cpf = "12345678901"

        assertEquals("12345678901", clienteSchema.cpf)
    }

    @Test
    fun `deveSetarAPropriedadeNome`() {
        val clienteSchema = ClienteSchema(null, "99999999999", "João", "email@email.com")

        clienteSchema.nome = "Maria"

        // Assert
        assertEquals("Maria", clienteSchema.nome)
    }

    @Test
    fun `deveSetarAPropriedadeEmail`() {
        val clienteSchema = ClienteSchema(null, "99999999999", "João", "email@email.com")

        clienteSchema.email = "maria@email.com"

        // Assert
        assertEquals("maria@email.com", clienteSchema.email)
    }
}
