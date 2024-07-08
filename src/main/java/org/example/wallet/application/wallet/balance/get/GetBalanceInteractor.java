package org.example.wallet.application.wallet.balance.get;

import lombok.AllArgsConstructor;
import org.example.wallet.application.wallet.exception.WalletNotFoundException;
import org.example.wallet.domain.wallet.repository.WalletQueryRepository;

@AllArgsConstructor
public class GetBalanceInteractor implements GetBalanceUseCase {
    private final WalletQueryRepository walletQueryRepository;

    @Override
    public GetBalanceResult execute(GetBalanceCommand command) {
        final var optionalWalletDomain = walletQueryRepository.getByeUserId(command.userId());

        if (optionalWalletDomain.isEmpty())
            throw new WalletNotFoundException(command.userId().value());

        return new GetBalanceResult(optionalWalletDomain.get().getBalance());
    }
}
