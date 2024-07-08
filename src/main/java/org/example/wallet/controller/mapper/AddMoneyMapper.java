package org.example.wallet.controller.mapper;

import org.example.wallet.application.wallet.balance.add.AddMoneyCommand;
import org.example.wallet.application.wallet.balance.add.AddMoneyResult;
import org.example.wallet.controller.model.add.money.AddMoneyRequest;
import org.example.wallet.controller.model.add.money.AddMoneyResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AddMoneyMapper {
    @Mapping(target = "userId.value", source = "userId")
    @Mapping(target = "amount.value", source = "amount")
    AddMoneyCommand map(AddMoneyRequest source);

    @Mapping(target = "referenceId", source = "referenceId.value")
    AddMoneyResponse map(AddMoneyResult source);
}
