CREATE TABLE IF NOT EXISTS cliente (
    id UUID NOT NULL default gen_random_uuid(),
    cpf VARCHAR(11) UNIQUE,
    nome VARCHAR(255),
    email VARCHAR(255),
    constraint pk_cliente PRIMARY KEY (id)
);
