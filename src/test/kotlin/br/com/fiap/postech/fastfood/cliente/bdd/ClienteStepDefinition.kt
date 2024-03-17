package br.com.fiap.postech.fastfood.cliente.bdd

import br.com.fiap.postech.fastfood.cliente.adapter.presenter.ClienteRequest
import br.com.fiap.postech.fastfood.cliente.adapter.presenter.ClienteResponse
import io.cucumber.java.Before
import io.cucumber.java.pt.Dado
import io.cucumber.java.pt.Então
import io.cucumber.java.pt.Quando
import io.restassured.response.Response
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

import io.restassured.RestAssured.given
import java.math.BigDecimal
import java.util.*

class ClienteStepDefinition {

    private var response: Response? = null

    private var clienteResponse: ClienteResponse? = null

    private val ENDPOINT = "http://localhost:8094/cliente"
    private val ENDPOINT_AUTENTICAR = "http://localhost:8094/autenticar"

    @Quando("submeter um novo cliente")
    fun `submeter um novo cliente`(): ClienteResponse {
        val clienteRequest: Any = clienteRequest("12345678901", "João da Silva", "joao@gmail.com", "Endereco", "99999999999")
        response = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(clienteRequest)
                .`when`().post(ENDPOINT)
        return response!!.then().extract().`as`(ClienteResponse::class.java)
    }

    @Então("o cliente e registrado com sucesso")
    fun `o cliente e registrado com sucesso`() {
        response!!.then().statusCode(HttpStatus.CREATED.value())
    }

    @Quando("submeter um novo cliente com email inválido")
    fun `submeter um novo cliente com email inválido`() {
        val clienteRequest: ClienteRequest = clienteRequest("12345678902", "Maria Oliveira", "maria_email_invalido", "Endereco", "99999999999")
        response = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(clienteRequest)
                .`when`().post(ENDPOINT)
    }

    @Então("a API retorna uma mensagem de erro informando que o email é inválido")
    fun `a API retorna uma mensagem de erro informando que o email é inválido`() {
        response!!.then().statusCode(HttpStatus.UNPROCESSABLE_ENTITY.value())
    }

    @Dado("que existe um cliente cadastrado com o CPF {string}")
    fun `que existe um cliente cadastrado com o CPF`(cpf: String) {
        val clienteRequest: ClienteRequest = clienteRequest(cpf, "João da Silva", "joao_cpf_invalido@gmail.com", "Endereco", "99999999999")
        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(clienteRequest)
                .`when`().post(ENDPOINT)
                .then().statusCode(HttpStatus.CREATED.value())
    }

    @Quando("submeter um novo cliente com o mesmo CPF {string}")
    fun `submeter um novo cliente com o mesmo CPF`(cpf: String) {
        val clienteRequest: ClienteRequest = clienteRequest(cpf, "Maria Oliveira", "maria_cpf_invalido@gmail.com", "Endereco", "99999999999")
        response = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(clienteRequest)
                .`when`().post(ENDPOINT)
    }

    @Então("a API retorna uma mensagem de erro informando que o cliente já existe")
    fun `a API retorna uma mensagem de erro informando que o cliente já existe`() {
        response!!.then().statusCode(HttpStatus.UNPROCESSABLE_ENTITY.value())
    }

    @Dado("que existe um cliente cadastrado com o email {string}")
    fun `que existe um cliente cadastrado com o email`(email: String) {
        val clienteRequest: ClienteRequest = clienteRequest("12345678904", "João da Silva", email, "Endereco", "99999999999")
        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(clienteRequest)
                .`when`().post(ENDPOINT)
                .then().statusCode(HttpStatus.CREATED.value())
    }

    @Quando("submeter um novo cliente com o mesmo email {string}")
    fun `submeter um novo cliente com o mesmo email`(email: String) {
        val clienteRequest: ClienteRequest = clienteRequest("78901234567", "Maria Oliveira", email, "Endereco", "99999999999")
        response = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(clienteRequest)
                .`when`().post(ENDPOINT)
    }

    @Então("a API retorna uma mensagem de erro informando que o cliente com o email já existe")
    fun `a API retorna uma mensagem de erro informando que o cliente com o email já existe`() {
        response!!.then().statusCode(HttpStatus.UNPROCESSABLE_ENTITY.value())
    }

    @Dado("que existe um cliente cadastrado com o CPF {string} e email {string}")
    fun `que existe um cliente cadastrado com o CPF`(cpf: String, email: String) {
        val clienteRequest: ClienteRequest = clienteRequest(cpf, "Cliente Existente", email, "Endereco", "99999999999")
        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(clienteRequest)
                .`when`().post(ENDPOINT)
                .then().statusCode(HttpStatus.CREATED.value())
    }

    @Quando("realizar a busca por cliente utilizando o CPF {string}")
    fun `realizar a busca por cliente utilizando o CPF`(cpf: String) {
        response = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .`when`().get("$ENDPOINT?cpf=$cpf")
    }

    @Então("a API retorna as informações do cliente correspondente")
    fun `a API retorna as informações do cliente correspondente`() {
        response!!.then().statusCode(HttpStatus.OK.value())
    }

    @Quando("realizar a busca por cliente utilizando um CPF inexistente")
    fun `realizar a busca por cliente utilizando um CPF inexistente`() {
        response = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .`when`().get("$ENDPOINT?cpf=98754568766")
    }

    @Então("a API retorna uma mensagem informando que o cliente não foi encontrado")
    fun `a API retorna uma mensagem informando que o cliente não foi encontrado`() {
        response!!.then().statusCode(HttpStatus.NOT_FOUND.value())
    }

    @Quando("realizar a autenticacao desse cliente")
    fun `realizar a autenticacao desse cliente`() {
        val cpfExistente = "98765432109"
        response = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .`when`().get("$ENDPOINT_AUTENTICAR?cpf=$cpfExistente")
    }

    @Então("a API retorna uma mensagem informando que o cliente está autenticado")
    fun `a API retorna uma mensagem informando que o cliente está autenticado`() {
        response!!.then().statusCode(HttpStatus.OK.value())
    }

    fun clienteRequest(cpf: String, nome: String, email: String, endereco: String, telefone: String): ClienteRequest {
        return ClienteRequest(
            cpf = cpf,
            nome = nome,
            email = email,
            endereco = endereco,
            telefone = telefone
        )
    }
}