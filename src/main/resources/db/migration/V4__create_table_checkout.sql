CREATE TABLE IF NOT EXISTS checkout (
    id UUID NOT NULL default gen_random_uuid(),
    pedido_id UUID,
    status VARCHAR(10),
    constraint pk_checkout PRIMARY KEY (id),
    constraint fk_pedido FOREIGN KEY (pedido_id) REFERENCES pedido(id)
);

