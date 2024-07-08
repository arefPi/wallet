package org.example.wallet.infrastructure.repository;

import lombok.AllArgsConstructor;
import org.example.wallet.domain.transaction.repository.TransactionQueryRepository;
import org.example.wallet.infrastructure.persistance.repository.TransactionJpaEntityRepository;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class TransactionQueryRepositoryImpl implements TransactionQueryRepository {
    private final TransactionJpaEntityRepository transactionJpaEntityRepository;

    @Override
    public long sumTotalAmount() {
        return transactionJpaEntityRepository.sumTotalAmount();
    }
}
