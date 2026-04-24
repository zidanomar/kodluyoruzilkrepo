package com.atm.bank.service.strategy;

import com.atm.bank.domain.Account;
import com.atm.bank.domain.Transaction;
import com.atm.bank.domain.TransactionType;
import com.atm.bank.exception.DomainException;
import com.atm.bank.repository.AccountRepository;
import com.atm.bank.repository.TransactionRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class WithdrawStrategy extends AbstractTransactionStrategy {

    public WithdrawStrategy(AccountRepository a, TransactionRepository t, ApplicationEventPublisher e) {
        super(a, t, e);
    }

    @Override
    public TransactionType supports() {
        return TransactionType.WITHDRAW;
    }

    @Override
    protected Transaction doExecute(Account account, TransactionContext ctx) {
        if (account.getBalance().compareTo(ctx.amount()) < 0) {
            throw DomainException.badRequest("Insufficient balance");
        }
        account.debit(ctx.amount());
        accountRepo.save(account);
        return buildTx(account, null, TransactionType.WITHDRAW, ctx.amount(), ctx.description(), account.getBalance());
    }
}
