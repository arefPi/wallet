package org.example.wallet.domain.wallet.repository;

import org.example.wallet.domain.UserId;
import org.example.wallet.domain.wallet.Wallet;

import java.util.Optional;

public interface WalletQueryRepository {
    Optional<Wallet> getByeUserId(UserId userId);
}
