package org.example.wallet.application.wallet.balance.add;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.example.wallet.application.wallet.balance.add.provider.ReferenceIdProvider;
import org.example.wallet.application.wallet.exception.WalletNotFoundException;
import org.example.wallet.domain.Amount;
import org.example.wallet.domain.transaction.Transaction;
import org.example.wallet.domain.transaction.TransactionType;
import org.example.wallet.domain.transaction.repository.TransactionCommandRepository;
import org.example.wallet.domain.wallet.Wallet;
import org.example.wallet.domain.wallet.repository.WalletCommandRepository;
import org.example.wallet.domain.wallet.repository.WalletQueryRepository;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Transactional
public class AddMoneyInteractor implements AddMoneyUseCase {
    private final WalletQueryRepository walletQueryRepository;
    private final WalletCommandRepository walletCommandRepository;
    private final ReferenceIdProvider referenceIdProvider;
    private final TransactionCommandRepository transactionCommandRepository;

    @Override
    public AddMoneyResult execute(@NonNull AddMoneyCommand command) {
        final var optionalWalletDomain = walletQueryRepository.getByeUserId(command.userId());

        if (optionalWalletDomain.isEmpty())
            throw new WalletNotFoundException(command.userId().value());

        final var walletDomain = optionalWalletDomain.get();

        walletDomain.addMoney(command.amount());
        walletCommandRepository.save(walletDomain);

        final var transaction = createTransaction(walletDomain, command.amount());
        transactionCommandRepository.save(transaction);

        return new AddMoneyResult(transaction.getReferenceId());
    }

    private Transaction createTransaction(Wallet wallet, Amount amount) {
        final var referenceId = referenceIdProvider.provide();
        final var transactionType = amount.value() < 0 ? TransactionType.DEBIT : TransactionType.CREDIT;

        return Transaction.create(referenceId,
                wallet.getUserId(),
                amount,
                wallet.getBalance(),
                transactionType);
    }
}
