package org.example.wallet.infrastructure.repository;

import lombok.AllArgsConstructor;
import org.example.wallet.domain.wallet.Wallet;
import org.example.wallet.domain.wallet.repository.WalletCommandRepository;
import org.example.wallet.infrastructure.persistance.repository.WalletJpaEntityRepository;
import org.example.wallet.infrastructure.repository.mapper.WalletMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class WalletCommandRepositoryImp implements WalletCommandRepository {
    private final WalletJpaEntityRepository walletJpaEntityRepository;
    private final WalletMapper walletMapper;

    @Override
    public void save(Wallet wallet) {
        final var walletJpaEntity = walletMapper.map(wallet);
        walletJpaEntityRepository.save(walletJpaEntity);
    }
}
