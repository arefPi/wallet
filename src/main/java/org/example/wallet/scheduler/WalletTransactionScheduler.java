package org.example.wallet.scheduler;

import lombok.AllArgsConstructor;
import org.example.wallet.domain.transaction.repository.TransactionQueryRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class WalletTransactionScheduler {
    private final TransactionQueryRepository transactionQueryRepository;

    @Scheduled(cron = "0 0 0 * * ?")
    public void calculateTotalAmount() {
        final var totalAmount = transactionQueryRepository.sumTotalAmount();
        System.out.println("TotalAmount: " + totalAmount);
    }
}
