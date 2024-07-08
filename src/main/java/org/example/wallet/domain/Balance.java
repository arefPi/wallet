package org.example.wallet.domain;

import org.example.wallet.domain.exception.IllegalBalanceException;
import org.example.wallet.domain.exception.IllegalUserIdException;

public record Balance(int value) {
    private static final String BALANCE_SHOULD_NOT_BE_NEGATIVE = "BALANCE_SHOULD_NOT_BE_NEGATIVE";

    public Balance {
        if (value < 0)
            throw new IllegalBalanceException(BALANCE_SHOULD_NOT_BE_NEGATIVE);
    }


}
