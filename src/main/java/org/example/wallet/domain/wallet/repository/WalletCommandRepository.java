package org.example.wallet.domain.wallet.repository;

import org.example.wallet.domain.wallet.Wallet;

public interface WalletCommandRepository {
    void save(Wallet wallet);
}
