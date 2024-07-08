package org.example.wallet.controller.mapper;

import org.example.wallet.application.wallet.balance.get.GetBalanceCommand;
import org.example.wallet.application.wallet.balance.get.GetBalanceResult;
import org.example.wallet.controller.model.get.balance.GetBalanceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface GetBalanceMapper {
    @Mapping(target = "userId.value", source = "userId")
    GetBalanceCommand map(String userId);

    @Mapping(target = "balance", source = "balance.value")
    GetBalanceResponse map(GetBalanceResult source);
}
