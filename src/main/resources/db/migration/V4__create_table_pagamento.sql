CREATE TABLE IF NOT EXISTS pagamento (
    id UUID NOT NULL default gen_random_uuid(),
    valor numeric(12, 2),
    forma_pagamento VARCHAR(50),
    status VARCHAR(50),
    qrCodeId UUID NOT NULL,
    qrCode VARCHAR(255),
    constraint pk_pagamento PRIMARY KEY (id)
)
