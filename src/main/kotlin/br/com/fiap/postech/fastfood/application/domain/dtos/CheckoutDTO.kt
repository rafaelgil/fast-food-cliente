package br.com.fiap.postech.fastfood.application.domain.dtos

import br.com.fiap.postech.fastfood.domain.valueObjets.FormaPagamento
import br.com.fiap.postech.fastfood.domain.valueObjets.StatusCheckout
import com.fasterxml.jackson.annotation.JsonProperty
import org.apache.tomcat.util.buf.UDecoder
import java.time.LocalDateTime
import java.util.*

data class CheckoutDTO(

    var id: UUID? = null,
    var pedido: PedidoDTO? = null,
    var status: String? = null,
    var pagamento: PagamentoDTO? = null,
    var data: LocalDateTime? = null
)
