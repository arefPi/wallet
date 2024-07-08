package org.example.wallet.domain.transaction.repository;

import org.example.wallet.domain.transaction.Transaction;

public interface TransactionCommandRepository {
    void save(Transaction transaction);
}
