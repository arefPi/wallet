package org.example.wallet.infrastructure.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "wallet_transaction")
@Getter
@Setter
@NoArgsConstructor
public class TransactionJpaEntity extends EntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "userId")
    private String userId;

    @Column(name = "amount")
    private int amount;

    @Column(name = "balance")
    private int balance;

    @Column(name = "reference_id")
    private String referenceId;

    @Column(name = "transaction_type")
    private String transactionType;
}
