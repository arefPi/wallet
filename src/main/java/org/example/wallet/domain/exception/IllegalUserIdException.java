package org.example.wallet.domain.exception;

public class IllegalUserIdException extends IllegalArgumentException {
    public IllegalUserIdException(String s) {
        super(s);
    }
}
