CREATE TABLE IF NOT EXISTS pedido (
    id UUID NOT NULL,
    cliente_id UUID,
    data TIMESTAMP,
    data_recebimento TIMESTAMP,
    status VARCHAR(50),
    pagamento_id UUID,
    constraint pk_pedido PRIMARY KEY (id),
    CONSTRAINT fk_cliente_pedido FOREIGN KEY (cliente_id) REFERENCES cliente (id) ON DELETE SET NULL
);

