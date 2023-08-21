CREATE TABLE IF NOT EXISTS checkout (
    id UUID NOT NULL default gen_random_uuid(),
    pedido_id UUID NOT NULL,
    pagamento_id UUID NOT NULL,
    status VARCHAR(20),
    data timestamp NOT NULL,
    constraint pk_checkout PRIMARY KEY (id),
    constraint fk_pedido_checkout FOREIGN KEY (pedido_id) REFERENCES pedido(id),
    constraint fk_pagamento_checkout FOREIGN KEY (pagamento_id) REFERENCES pagamento(id)
);

