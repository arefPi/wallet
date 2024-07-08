package org.example.wallet.infrastructure.persistance.repository;

import org.example.wallet.infrastructure.persistance.entity.WalletJpaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface WalletJpaEntityRepository extends CrudRepository<WalletJpaEntity, String> {
    Optional<WalletJpaEntity> findByUserId(String userId);
}
