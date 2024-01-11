CREATE TABLE IF NOT EXISTS item_pedido (
    id UUID NOT NULL default gen_random_uuid(),
    pedido_id UUID,
    produto_id UUID,
    quantidade int,
    preco numeric(10,2),
    constraint pk_item_pedido PRIMARY KEY (id),
    CONSTRAINT fk_pedido_item FOREIGN KEY (pedido_id) REFERENCES pedido (id) ON DELETE SET NULL,
    CONSTRAINT fk_produto_item FOREIGN KEY (produto_id) REFERENCES produto (id) ON DELETE SET NULL
);
