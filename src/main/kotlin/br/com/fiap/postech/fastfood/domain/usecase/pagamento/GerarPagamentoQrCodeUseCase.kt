package br.com.fiap.postech.fastfood.domain.usecase.pagamento

import br.com.fiap.postech.fastfood.domain.entity.Pagamento
import br.com.fiap.postech.fastfood.domain.entity.Pedido
import br.com.fiap.postech.fastfood.domain.valueObjets.FormaPagamento
import br.com.fiap.postech.fastfood.domain.valueObjets.StatusPagamento
import java.util.*

class GerarPagamentoQrCodeUseCase {

    fun executa(pedido: Pedido): Pagamento {
        val qrCode = gerarFakeQrCode(pedido)

        return Pagamento(
            formaPagamento = FormaPagamento.QR_CODE,
            valor = pedido.valorTotal(),
            status = StatusPagamento.AGUARDANDO_PAGAMENTO,
            qrCodeId = UUID.randomUUID(),
            qrCode = qrCode
        )
    }

    private fun gerarFakeQrCode(pedido: Pedido): String? {
        return "QRCODE_" + generateInternal(pedido)
    }

    private fun generateInternal(pedido: Pedido): String {
        val sb = StringBuilder()
        sb.append(pedido.cliente.nome)
        sb.append(pedido.cliente.email)
        sb.append(pedido.id)

        return sb.toString()
    }

}