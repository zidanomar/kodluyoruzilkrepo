package com.atm.bank.service.strategy;

import java.math.BigDecimal;

public record TransactionContext(Long accountId, String counterpartyAccountNumber,
                                 BigDecimal amount, String description, Long initiatedBy) {}
