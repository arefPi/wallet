package org.example.wallet.application.wallet.balance.get;

public interface GetBalanceUseCase {
    GetBalanceResult execute(GetBalanceCommand command);
}
