package com.atm.bank.dto.transaction;

import com.atm.bank.domain.Transaction;
import com.atm.bank.domain.TransactionStatus;
import com.atm.bank.domain.TransactionType;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Optional;

public record TransactionResponse(
        Long id,
        TransactionType type,
        TransactionStatus status,
        BigDecimal amount,
        BigDecimal balanceAfter,
        String counterpartyAccount,
        String description,
        Instant createdAt) {

    public static TransactionResponse from(Transaction t) {
        return new TransactionResponse(
                t.getId(),
                t.getType(),
                t.getStatus(),
                t.getAmount(),
                t.getBalanceAfter(),
                Optional.ofNullable(t.getCounterpartyAccount()).map(a -> a.getAccountNumber()).orElse(null),
                t.getDescription(),
                t.getCreatedAt());
    }
}
