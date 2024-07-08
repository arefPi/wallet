package org.example.wallet.domain.exception;

public class IllegalBalanceException extends IllegalAmountException {
    public IllegalBalanceException(String s) {
        super(s);
    }
}
