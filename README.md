# fast-food
Sistema de controle de pedidos que permite aos clientes selecionar e fazer os pedidos sem interagir com o atendente e integração com as areas da lanchonete como cozinha e o balcão para recebimento.

## Tecnologias
* Kotlin
* Database Migration
* Spring Boot Data Jpa
* Spring Boot Web
* Docker
* Docker Compose

## Banco de Dados
* PostgreSQL

### Build do projeto
```bash
./gradlew clean build
```
OBS: Importante rodar esse comando antes de subir a aplicação pelo docker-compose

### Comandos para iniciar a aplicação
Após qualquer alteração no projeto fast-fodd é importante atualizar a imagem deste. Então rodar o comando abaixo 
```bash
docker compose build
```
Iniciar a aplicação, a porta da aplicação é 8094(http://localhost:8094)
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
 curl --location 'http://localhost:8094/cliente' \
--header 'Content-Type: application/json' \
--data-raw '{
    "cpf":"45612378952",
    "nome":"João da Silva",
    "email":"joao@mock.com"
}'
```

### Buscar Clientes por CPF
```bash
curl --location --request GET 'http://localhost:8094/cliente?cpf=45612378952' \
--header 'Content-Type: application/json' \
--data-raw '{
    "cpf":"45612378952",
    "nome":"João da Silva",
    "email":"joao@mock.com"
}'
```

### Cadastrar produto
```bash
curl --location 'http://localhost:8094/produto' \
--header 'Content-Type: application/json' \
--data '{
    "descricao": "X-Bacon",
    "categoria": "Lanche",
    "preco": "45.56"
}'
```

### Cadastrar produto
```bash
curl --location 'http://localhost:8094/produto' \
--header 'Content-Type: application/json' \
--data '{
    "descricao": "X-Bacon",
    "categoria": "Lanche",
    "preco": "45.56"
}'
```
OBS: As categorias aceitas são LANCHE, BEBIDA e ACOMPANHAMENTO

### Atualizar produto
```bash
curl --location --request PUT 'http://localhost:8094/produto/6c90811d-08ca-4116-a900-5a6f420ac1c1' \
--header 'Content-Type: application/json' \
--data '{    
    "descricao": "X-Bacon",
    "categoria": "LANCHE",
    "preco": 34.00
}'
```

### Buscar por categoria
```bash
curl --location 'http://localhost:8094/produto/categoria?nome=lanche' \
--header 'Content-Type: application/json'
```

### Remover produto
```
curl --location --request DELETE 'http://localhost:8094/produto/6c90811d-08ca-4116-a900-5a6f420ac1c1' \
--header 'Content-Type: application/json'
```



