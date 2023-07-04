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
curl --request GET \
  --url 'http://localhost:8094/cliente?cpf=45612378952' \
  --header 'Content-Type: application/json'
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
```bash
curl --location --request DELETE 'http://localhost:8094/produto/6c90811d-08ca-4116-a900-5a6f420ac1c1' \
--header 'Content-Type: application/json'
```

### Cadastrar Pedido
```bash 
curl --request POST \
  --url http://localhost:8094/pedido \
  --header 'Content-Type: application/json' \
  --data '{
	"id_cliente":"9f961b3d-1f4a-4f5a-a06e-9b6d21daad94",
	"id_lanche":"d8a0d839-62e6-4b27-a7db-00b58b745385",
	"id_bebida":"71d73f33-1f1f-44de-baaa-f2b395d27d56",
	"id_acompanhamento":"699e1dca-62e7-4cd2-8ebe-f82088db1625"
}'
```

### Atualizar Pedido
```bash 
curl --request PUT \
  --url http://localhost:8094/pedido/1cf5afc9-dbc2-40d6-876c-21214ac25388 \
  --header 'Content-Type: application/json' \
  --data '{
	"id_cliente":"9f961b3d-1f4a-4f5a-a06e-9b6d21daad94",
	"id_lanche":"d8a0d839-62e6-4b27-a7db-00b58b745385",
	"id_bebida":"71d73f33-1f1f-44de-baaa-f2b395d27d56",
	"id_acompanhamento":"699e1dca-62e7-4cd2-8ebe-f82088db1625"
}'
```

### Listar Pedidos
```bash 
curl --request GET \
  --url http://localhost:8094/pedido/listar
```

### Gerar Checkout
```bash
curl --request POST \
  --url http://localhost:8094/checkout \
  --header 'Content-Type: application/json' \
  --data '{
	"id_pedido":"6dde3931-87a7-4c0c-bf68-0a39842c6f11",
	"forma_pagamento":"PIX"
}'
```
