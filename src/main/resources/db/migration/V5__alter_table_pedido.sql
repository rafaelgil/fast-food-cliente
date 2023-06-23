ALTER TABLE pedido
    ADD COLUMN cliente_id UUID,
    ADD COLUMN lanche_id UUID,
    ADD COLUMN bebida_id UUID,
    ADD COLUMN acompanhamento_id UUID,
    ADD COLUMN sobremesa_id UUID;

ALTER TABLE pedido
    ADD CONSTRAINT fk_pedido_cliente FOREIGN KEY (cliente_id) REFERENCES cliente (id) ON DELETE SET NULL,
    ADD CONSTRAINT fk_pedido_lanche FOREIGN KEY (lanche_id) REFERENCES produto (id),
    ADD CONSTRAINT fk_pedido_bebida FOREIGN KEY (bebida_id) REFERENCES produto (id),
    ADD CONSTRAINT fk_pedido_acompanhamento FOREIGN KEY (acompanhamento_id) REFERENCES produto (id),
    ADD CONSTRAINT fk_pedido_sobremesa FOREIGN KEY (sobremesa_id) REFERENCES produto (id);