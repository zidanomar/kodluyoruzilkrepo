package com.atm.bank.event;

import com.atm.bank.domain.Transaction;

public record TransactionEvent(Transaction transaction, Long initiatedBy) {}
