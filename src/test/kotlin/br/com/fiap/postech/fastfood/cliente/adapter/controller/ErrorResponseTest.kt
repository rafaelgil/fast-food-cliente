import br.com.fiap.postech.fastfood.cliente.adapter.controller.ErrorResponse
import junit.framework.TestCase.assertEquals
import org.junit.jupiter.api.Test

class ErrorResponseTest {

    @Test
    fun `deveSetarAPropriedadeCodigoHttp`() {
        val errorResponse = ErrorResponse(0, "")

        errorResponse.codigoHttp = 404

        assertEquals(404, errorResponse.codigoHttp)
    }

    @Test
    fun `deveSetarAPropriedadeMensagem`() {
        val errorResponse = ErrorResponse(0, "")

        errorResponse.mensagem = "Not Found"

        assertEquals("Not Found", errorResponse.mensagem)
    }
}