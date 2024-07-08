package org.example.wallet.infrastructure.repository.mapper;

import org.example.wallet.domain.wallet.Wallet;
import org.example.wallet.infrastructure.persistance.entity.WalletJpaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface WalletMapper {
    @Mapping(source = "id.value", target = "id")
    @Mapping(source = "userId.value", target = "userId")
    @Mapping(source = "balance.value", target = "balance")
    WalletJpaEntity map(Wallet source);


}
