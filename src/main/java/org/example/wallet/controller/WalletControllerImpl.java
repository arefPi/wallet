package org.example.wallet.controller;

import lombok.AllArgsConstructor;
import org.example.wallet.application.wallet.balance.add.AddMoneyUseCase;
import org.example.wallet.application.wallet.balance.get.GetBalanceUseCase;
import org.example.wallet.controller.mapper.AddMoneyMapper;
import org.example.wallet.controller.mapper.GetBalanceMapper;
import org.example.wallet.controller.model.add.money.AddMoneyRequest;
import org.example.wallet.controller.model.add.money.AddMoneyResponse;
import org.example.wallet.controller.model.get.balance.GetBalanceResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/wallet")
@AllArgsConstructor
public class WalletControllerImpl implements WalletController {
    private final GetBalanceUseCase getBalanceUseCase;
    private final GetBalanceMapper getBalanceMapper;

    private final AddMoneyUseCase addMoneyUseCase;
    private final AddMoneyMapper addMoneyMapper;


    @Override
    @GetMapping("/balance/{user-id}")
    public GetBalanceResponse getBalance(@PathVariable("user-id") String userId) {
        final var getBalanceCommand = getBalanceMapper.map(userId);

        final var getBalanceResult = getBalanceUseCase.execute(getBalanceCommand);

        return getBalanceMapper.map(getBalanceResult);
    }

    @Override
    @PostMapping("/add-money")
    public AddMoneyResponse addMoney(@RequestBody AddMoneyRequest request) {
        final var addMoneyCommand = addMoneyMapper.map(request);

        final var addMoneyResult = addMoneyUseCase.execute(addMoneyCommand);

        return addMoneyMapper.map(addMoneyResult);
    }
}
