package com.atm.bank.service.strategy;

import com.atm.bank.domain.Account;
import com.atm.bank.domain.Transaction;
import com.atm.bank.domain.TransactionType;
import com.atm.bank.repository.AccountRepository;
import com.atm.bank.repository.TransactionRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class DepositStrategy extends AbstractTransactionStrategy {

    public DepositStrategy(AccountRepository a, TransactionRepository t, ApplicationEventPublisher e) {
        super(a, t, e);
    }

    @Override
    public TransactionType supports() {
        return TransactionType.DEPOSIT;
    }

    @Override
    protected Transaction doExecute(Account account, TransactionContext ctx) {
        account.credit(ctx.amount());
        accountRepo.save(account);
        return buildTx(account, null, TransactionType.DEPOSIT, ctx.amount(), ctx.description(), account.getBalance());
    }
}
