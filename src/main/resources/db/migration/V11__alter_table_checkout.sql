ALTER TABLE checkout
    DROP COLUMN forma_pagamento,
    ADD COLUMN id_pagamento UUID,
    ADD CONSTRAINT fk_pagamento FOREIGN KEY (id_pagamento) REFERENCES pagamento (id);
