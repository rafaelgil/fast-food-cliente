package br.com.fiap.postech.fastfood.adapter.controller

import br.com.fiap.postech.fastfood.adapter.presenter.*
import br.com.fiap.postech.fastfood.domain.usecase.cliente.BuscarClientePorCPFUseCase
import br.com.fiap.postech.fastfood.domain.usecase.cliente.CadastrarClienteUseCase
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*
import javax.crypto.SecretKey

@RestController
@RequestMapping("cliente")
class ClienteController (
    private val cadastrarClienteUseCase: CadastrarClienteUseCase,
    private val buscarClientePorCPFUseCase: BuscarClientePorCPFUseCase
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastrarCliente(@RequestBody cliente: ClienteRequest): ClienteResponse {
        return cadastrarClienteUseCase.executa(cliente.toCliente()).toClienteResponse()
    }

    @GetMapping
    fun buscarCliente(@RequestParam cpf: String): ClienteResponse {
        return buscarClientePorCPFUseCase.executa(cpf).toClienteResponse()
    }

    @GetMapping("/autenticar")
    fun autenticaCliente(@RequestParam cpf: String): ClienteAutenticado {

        val base64Secret =
            "Y2hhdmUtc2VjcmV0YS1sYW1iZGEtZmFzdC1mb29kLWZpYXAtcG9zdGVjaC10dXJtYS1kZS1hcnF1aXRldHVyYS1kZS1zb2Z0d2FyZQo="
        val keyBytes: ByteArray = Decoders.BASE64.decode(base64Secret)
        val CHAVE: SecretKey = Keys.hmacShaKeyFor(keyBytes)

        val cliente = buscarClientePorCPFUseCase.executa(cpf).toClienteResponse()

        val jwtToken = Jwts.builder()
            .setSubject(cliente.cpf)
            .setIssuedAt(Date())
            .setExpiration(Date.from(
                LocalDateTime.now()
                    .plusMinutes(15L)
                    .atZone(ZoneId.systemDefault())
                    .toInstant()))
            .signWith(CHAVE, SignatureAlgorithm.HS512)
            .compact()

        val response = ClienteAutenticado(
            mensagem = "Cliente autenticado",
            token = jwtToken
        )

        return response
    }
}