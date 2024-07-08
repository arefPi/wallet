CREATE TABLE IF NOT EXISTS wallet_transaction
(
    id             varchar(64) PRIMARY KEY,
    reference_id   varchar(64) NOT NULL,
    user_id        varchar(10) NOT NULL,
    amount         integer NOT NULL,
    balance        integer NOT NULL,
    transaction_type varchar(10) NULL,
    creation_date  timestamp DEFAULT CURRENT_TIMESTAMP,
    update_date    timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_wallet_transaction_user_id ON wallet_transaction (user_id);