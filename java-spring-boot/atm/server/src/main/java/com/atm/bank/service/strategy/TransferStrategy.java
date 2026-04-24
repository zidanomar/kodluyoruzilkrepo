package com.atm.bank.service.strategy;

import com.atm.bank.domain.Account;
import com.atm.bank.domain.Transaction;
import com.atm.bank.domain.TransactionType;
import com.atm.bank.event.TransactionEvent;
import com.atm.bank.exception.DomainException;
import com.atm.bank.repository.AccountRepository;
import com.atm.bank.repository.TransactionRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class TransferStrategy extends AbstractTransactionStrategy {

    public TransferStrategy(AccountRepository a, TransactionRepository t, ApplicationEventPublisher e) {
        super(a, t, e);
    }

    @Override
    public TransactionType supports() {
        return TransactionType.TRANSFER_OUT;
    }

    @Override
    protected Transaction doExecute(Account account, TransactionContext ctx) {
        if (ctx.counterpartyAccountNumber() == null || ctx.counterpartyAccountNumber().isBlank()) {
            throw DomainException.badRequest("Counterparty account required");
        }
        if (account.getBalance().compareTo(ctx.amount()) < 0) {
            throw DomainException.badRequest("Insufficient balance");
        }
        Account target = accountRepo.findWithLockByAccountNumber(ctx.counterpartyAccountNumber())
                .orElseThrow(() -> DomainException.notFound("Target account not found"));
        if (target.getId().equals(account.getId())) {
            throw DomainException.badRequest("Cannot transfer to own account");
        }

        account.debit(ctx.amount());
        target.credit(ctx.amount());
        accountRepo.save(account);
        accountRepo.save(target);

        Transaction incoming = buildTx(target, account, TransactionType.TRANSFER_IN,
                ctx.amount(), ctx.description(), target.getBalance());
        Transaction savedIncoming = txRepo.save(incoming);
        events.publishEvent(new TransactionEvent(savedIncoming, ctx.initiatedBy()));

        return buildTx(account, target, TransactionType.TRANSFER_OUT,
                ctx.amount(), ctx.description(), account.getBalance());
    }
}
