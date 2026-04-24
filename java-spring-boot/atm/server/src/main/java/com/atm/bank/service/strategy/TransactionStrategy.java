package com.atm.bank.service.strategy;

import com.atm.bank.domain.Transaction;
import com.atm.bank.domain.TransactionType;

public interface TransactionStrategy {

    TransactionType supports();

    Transaction execute(TransactionContext ctx);
}
