package org.example.wallet.infrastructure.bean.config;

import org.example.wallet.application.wallet.balance.add.AddMoneyInteractor;
import org.example.wallet.application.wallet.balance.add.AddMoneyUseCase;
import org.example.wallet.application.wallet.balance.add.provider.ReferenceIdProvider;
import org.example.wallet.application.wallet.balance.get.GetBalanceInteractor;
import org.example.wallet.application.wallet.balance.get.GetBalanceUseCase;
import org.example.wallet.domain.transaction.repository.TransactionCommandRepository;
import org.example.wallet.domain.wallet.repository.WalletCommandRepository;
import org.example.wallet.domain.wallet.repository.WalletQueryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    GetBalanceUseCase getBalanceUseCase(WalletQueryRepository walletQueryRepository) {
        return new GetBalanceInteractor(walletQueryRepository);
    }

    @Bean
    AddMoneyUseCase addMoneyUseCase(WalletQueryRepository walletQueryRepository,
                                                WalletCommandRepository walletCommandRepository,
                                                ReferenceIdProvider referenceIdProvider,
                                                TransactionCommandRepository transactionCommandRepository) {
        return new AddMoneyInteractor(walletQueryRepository,
                walletCommandRepository,
                referenceIdProvider,
                transactionCommandRepository);
    }
}
