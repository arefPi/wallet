package org.example.wallet.domain.wallet;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.wallet.domain.Amount;
import org.example.wallet.domain.Balance;
import org.example.wallet.domain.Id;
import org.example.wallet.domain.UserId;
import org.example.wallet.domain.exception.IllegalAmountException;
import org.example.wallet.domain.exception.IllegalUserIdException;
import org.example.wallet.domain.exception.InsufficientBalanceException;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Wallet {
    private static final String USER_ID_SHOULD_NOT_BE_NULL = "USER_ID_SHOULD_NOT_BE_NULL";
    private static final String BALANCE_SHOULD_NOT_BE_NULL = "BALANCE_SHOULD_NOT_BE_NULL";

    private final Id id;
    private final UserId userId;
    private Balance balance;

    public static Wallet create(Id id, UserId userId, Balance balance) {
        if (userId == null)
            throw new IllegalUserIdException(USER_ID_SHOULD_NOT_BE_NULL);
        if (balance == null) {
            throw new IllegalUserIdException(BALANCE_SHOULD_NOT_BE_NULL);
        }

        return new Wallet(id, userId, balance);
    }

    public void addMoney(Amount amount) {
        final var result = balance.value() + amount.value();

        if (result < 0) {
            throw new InsufficientBalanceException();
        }

        this.balance = new Balance(result);
    }
}
