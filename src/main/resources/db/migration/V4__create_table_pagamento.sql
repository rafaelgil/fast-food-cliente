CREATE TABLE IF NOT EXISTS pagamento (
    id UUID NOT NULL default gen_random_uuid(),
    valor numeric(12, 2),
    forma_pagamento VARCHAR(50),
    status VARCHAR(50),
    qrcode_id UUID NOT NULL,
    qrcode VARCHAR(255),
    constraint pk_pagamento PRIMARY KEY (id)
)
