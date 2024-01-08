CREATE TABLE IF NOT EXISTS pagamento (
    id UUID NOT NULL default gen_random_uuid(),
    status VARCHAR(50),
    constraint pk_pagamento PRIMARY KEY (id)
)
