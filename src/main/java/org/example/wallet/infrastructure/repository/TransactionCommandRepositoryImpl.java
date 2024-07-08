package org.example.wallet.infrastructure.repository;

import lombok.AllArgsConstructor;
import org.example.wallet.domain.transaction.Transaction;
import org.example.wallet.domain.transaction.repository.TransactionCommandRepository;
import org.example.wallet.infrastructure.persistance.repository.TransactionJpaEntityRepository;
import org.example.wallet.infrastructure.repository.mapper.TransactionMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class TransactionCommandRepositoryImpl implements TransactionCommandRepository {
    private final TransactionJpaEntityRepository transactionJpaEntityRepository;
    private final TransactionMapper transactionMapper;

    @Override
    public void save(Transaction transaction) {
        final var transactionJpaEntity = transactionMapper.map(transaction);
        transactionJpaEntityRepository.save(transactionJpaEntity);
    }
}
