# language: pt
Funcionalidade: API - Cliente

  Cenário: Cadastrar um novo cliente
    Quando submeter um novo cliente
    Então o cliente e registrado com sucesso

  Cenário: Cadastrar um novo cliente utilizando um email inválido
    Quando submeter um novo cliente com email inválido
    Então a API retorna uma mensagem de erro informando que o email é inválido

  Cenário: Cadastrar um cliente que já existe
    Dado que existe um cliente cadastrado com o CPF "12345678903"
    Quando submeter um novo cliente com o mesmo CPF "12345678903"
    Então a API retorna uma mensagem de erro informando que o cliente já existe

    Dado que existe um cliente cadastrado com o email "joao_email_existe@gmail.com"
    Quando submeter um novo cliente com o mesmo email "joao_email_existe@gmail.com"
    Então a API retorna uma mensagem de erro informando que o cliente com o email já existe

  Cenário: Buscar cliente por CPF existente
    Dado que existe um cliente cadastrado com o CPF "98765432100" e email "joao_busca_cpf@gmail.com"
    Quando realizar a busca por cliente utilizando o CPF "98765432100"
    Então a API retorna as informações do cliente correspondente

  Cenário: Buscar cliente por CPF inexistente
    Quando realizar a busca por cliente utilizando um CPF inexistente
    Então a API retorna uma mensagem informando que o cliente não foi encontrado

