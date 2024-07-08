package org.example.wallet.application.wallet.exception;

public class WalletNotFoundException extends RuntimeException {
    private static final String WALLET_NOT_FOUND_EXCEPTION = "WALLET_NOT_FOUND_EXCEPTION";

    public WalletNotFoundException(String userId) {
        super(String.format(WALLET_NOT_FOUND_EXCEPTION + ": %s", WALLET_NOT_FOUND_EXCEPTION));
    }
}
