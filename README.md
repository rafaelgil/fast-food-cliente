# fast-food-cliente
Sistema de controle de pedidos que permite aos clientes selecionar e fazer os pedidos sem interagir com o atendente e integração com as areas da lanchonete como cozinha e o balcão para recebimento.

## Tecnologias
* Kotlin
* Database Migration
* Spring Boot Data Jpa
* Spring Boot Web
* Docker
* Docker Compose
* JaCoCo
* Cucumber

## Banco de Dados
* PostgreSQL

### Comandos para iniciar a aplicação
Iniciar a aplicação, a porta da aplicação é 8080(http://localhost:8080)
```bash
docker compose up -d
```
Parar a aplicação
```bash
docker compose down
```

## Endpoints
### Criação de Clientes
 ```bash
 curl --location 'http://localhost:8080/cliente' \
--header 'Content-Type: application/json' \
--data-raw '{
    "cpf":"45612378952",
    "nome":"João da Silva",
    "email":"joao@mock.com",
    "telefone":"99999999999",
    "endereco":"R. 10 Qd. 20 Lt. 14"
}'
```

### Buscar Clientes por CPF
```bash
curl --request GET \
  --url 'http://localhost:8080/cliente?cpf=45612378952' \
  --header 'Content-Type: application/json'
```

### Autenticar
```bash
curl --request GET \
  --url 'http://localhost:8080/autenticar?cpf=45612378952' \
  --header 'Content-Type: application/json'
```

### Solicitar Exclusão
 ```bash
curl --request DELETE \
  --url 'http://localhost:8080/cliente/solicitar-exclusao' \
--header 'Content-Type: application/json' \
--data-raw '{
    "cpf":"45612378952",
    "nome":"João da Silva",
    "email":"joao@mock.com",
    "telefone":"99999999999",
    "endereco":"R. 10 Qd. 20 Lt. 14"
}'
```