package org.example.wallet.domain.exception;

public class IllegalAmountException extends IllegalArgumentException{
    public IllegalAmountException(String s) {
        super(s);
    }
}
