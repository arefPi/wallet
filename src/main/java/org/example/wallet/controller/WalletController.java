package org.example.wallet.controller;

import org.example.wallet.controller.model.add.money.AddMoneyRequest;
import org.example.wallet.controller.model.add.money.AddMoneyResponse;
import org.example.wallet.controller.model.get.balance.GetBalanceResponse;

public interface WalletController {
    GetBalanceResponse getBalance(String userId);
    AddMoneyResponse addMoney(AddMoneyRequest request);
}
