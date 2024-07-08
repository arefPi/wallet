package org.example.wallet.infrastructure.repository;

import lombok.AllArgsConstructor;
import org.example.wallet.domain.Balance;
import org.example.wallet.domain.Id;
import org.example.wallet.domain.UserId;
import org.example.wallet.domain.wallet.Wallet;
import org.example.wallet.domain.wallet.repository.WalletQueryRepository;
import org.example.wallet.infrastructure.persistance.entity.WalletJpaEntity;
import org.example.wallet.infrastructure.persistance.repository.WalletJpaEntityRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class WalletQueryRepositoryImpl implements WalletQueryRepository {
    private final WalletJpaEntityRepository walletJpaEntityRepository;

    @Override
    public Optional<Wallet> getByeUserId(UserId userId) {
        final var walletJpaEntityOptional = walletJpaEntityRepository.findByUserId(userId.value());

        if (walletJpaEntityOptional.isEmpty())
            return Optional.empty();

        final var walletJpaEntity = walletJpaEntityOptional.get();
        final var wallet = createWallet(walletJpaEntity);

        return Optional.of(wallet);
    }

    private Wallet createWallet(WalletJpaEntity walletJpaEntity) {
        final var id = new Id(walletJpaEntity.getId());
        final var userId = new UserId(walletJpaEntity.getUserId());
        final var balance = new Balance(walletJpaEntity.getBalance());

        return Wallet.create(id, userId, balance);
    }
}
