package org.example.wallet.infrastructure.persistance.repository;

import org.example.wallet.infrastructure.persistance.entity.TransactionJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TransactionJpaEntityRepository extends CrudRepository<TransactionJpaEntity, String> {
    @Query("SELECT SUM(wt.amount) FROM TransactionJpaEntity wt")
    long sumTotalAmount();
}
