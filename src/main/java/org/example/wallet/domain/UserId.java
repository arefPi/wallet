package org.example.wallet.domain;

import org.example.wallet.domain.exception.IllegalUserIdException;

public record UserId(String value) {
    private static final String USER_ID_SHOULD_NOT_BE_NULL_OR_EMPTY = "USER_ID_SHOULD_NOT_BE_NULL_OR_EMPTY";

    public UserId {
       if (value == null || value.isBlank())
           throw new IllegalUserIdException(USER_ID_SHOULD_NOT_BE_NULL_OR_EMPTY);
    }
}
