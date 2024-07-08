package org.example.wallet.application.wallet.balance.get;

import org.example.wallet.domain.UserId;

public record GetBalanceCommand(UserId userId) {
}
