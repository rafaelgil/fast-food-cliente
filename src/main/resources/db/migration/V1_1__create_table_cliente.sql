CREATE TABLE IF NOT EXISTS cliente (
    id UUID NOT NULL default uuid_generate_v4(),
    cpf VARCHAR(11),
    nome VARCHAR(255),
    email VARCHAR(255),
    constraint pk_cliente PRIMARY KEY (id)
);