CREATE TABLE IF NOT EXISTS pedido (
    id UUID NOT NULL default gen_random_uuid(),
    cliente_id UUID,
    data TIMESTAMP,
    data_recebimento TIMESTAMP,
    status VARCHAR(50),
    constraint pk_pedido PRIMARY KEY (id),
    CONSTRAINT fk_cliente_pedido FOREIGN KEY (cliente_id) REFERENCES cliente (id) ON DELETE SET NULL
);

