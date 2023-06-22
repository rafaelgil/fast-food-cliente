CREATE TABLE IF NOT EXISTS pedido (
    id UUID NOT NULL default gen_random_uuid(),
    constraint pk_pedido PRIMARY KEY (id)
);

