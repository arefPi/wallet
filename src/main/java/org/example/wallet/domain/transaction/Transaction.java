package org.example.wallet.domain.transaction;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.wallet.domain.Amount;
import org.example.wallet.domain.Balance;
import org.example.wallet.domain.UserId;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Transaction {
    private final ReferenceId referenceId;
    private final UserId userId;
    private final Amount amount;
    private final Balance balance;
    private final TransactionType transactionType;

    public static Transaction create(ReferenceId referenceId,
                               UserId userId,
                               Amount amount,
                               Balance balance,
                               TransactionType transactionType) {
        // todo arguments must be validate
        return new Transaction(referenceId, userId, amount, balance, transactionType);
    }
}
