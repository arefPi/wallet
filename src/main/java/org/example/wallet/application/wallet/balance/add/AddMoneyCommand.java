package org.example.wallet.application.wallet.balance.add;

import org.example.wallet.domain.Amount;
import org.example.wallet.domain.UserId;

public record AddMoneyCommand(UserId userId, Amount amount) {
}
