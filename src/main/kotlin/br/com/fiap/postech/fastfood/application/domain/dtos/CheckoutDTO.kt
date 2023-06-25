package br.com.fiap.postech.fastfood.application.domain.dtos

import br.com.fiap.postech.fastfood.application.domain.valueObjets.StatusCheckout
import org.apache.tomcat.util.buf.UDecoder
import java.util.*

data class CheckoutDTO(

    var id: UUID? = null,
    var idPedido: UUID? = null,
    var status: StatusCheckout
)

data class CheckoutRequest (
    var idPedido: UUID? = null
)
