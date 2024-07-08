package org.example.wallet.infrastructure.repository.mapper;

import org.example.wallet.domain.transaction.Transaction;
import org.example.wallet.infrastructure.persistance.entity.TransactionJpaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TransactionMapper {

    @Mapping(source = "referenceId.value", target = "referenceId")
    @Mapping(source = "userId.value", target = "userId")
    @Mapping(source = "amount.value", target = "amount")
    @Mapping(source = "balance.value", target = "balance")
    @Mapping(source = "transactionType", target = "transactionType")
    TransactionJpaEntity map(Transaction source);
}
