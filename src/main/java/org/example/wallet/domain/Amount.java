package org.example.wallet.domain;

import org.example.wallet.domain.exception.IllegalAmountException;

public record Amount(int value) {
    private static final String AMOUNT_SHOULD_NOT_BE_NULL = "AMOUNT_SHOULD_NOT_BE_ZERO";

    public Amount {
        if (value == 0) {
            throw new IllegalAmountException(AMOUNT_SHOULD_NOT_BE_NULL);
        }
    }
}
