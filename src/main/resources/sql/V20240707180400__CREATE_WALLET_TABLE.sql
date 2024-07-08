CREATE TABLE IF NOT EXISTS wallet
(
    id             varchar(64) PRIMARY KEY,
    user_id        varchar(10) NOT NULL,
    balance        integer NOT NULL,
    creation_date  timestamp DEFAULT CURRENT_TIMESTAMP,
    update_date    timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_wallet_user_id ON wallet (user_id);

INSERT INTO wallet (id, user_id, balance)
VALUES ('123e4567-e89b-12d3-a456-426614174000', 'user123', 0);