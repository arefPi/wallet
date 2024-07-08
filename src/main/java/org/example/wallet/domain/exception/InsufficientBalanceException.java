package org.example.wallet.domain.exception;

public class InsufficientBalanceException extends RuntimeException {
    private static final String INSUFFICIENT_BALANCE = "INSUFFICIENT_BALANCE";

    public InsufficientBalanceException() {
        super(INSUFFICIENT_BALANCE);
    }
}
