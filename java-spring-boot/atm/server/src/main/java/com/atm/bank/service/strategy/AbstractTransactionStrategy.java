package com.atm.bank.service.strategy;

import com.atm.bank.domain.Account;
import com.atm.bank.domain.Transaction;
import com.atm.bank.domain.TransactionStatus;
import com.atm.bank.domain.TransactionType;
import com.atm.bank.event.TransactionEvent;
import com.atm.bank.exception.DomainException;
import com.atm.bank.repository.AccountRepository;
import com.atm.bank.repository.TransactionRepository;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

/**
 * Template Method + Strategy: concrete strategies override {@link #doExecute(Account, TransactionContext)}
 * while this base class handles validation, persistence, and event publication.
 */
@RequiredArgsConstructor
public abstract class AbstractTransactionStrategy implements TransactionStrategy {

    protected final AccountRepository accountRepo;
    protected final TransactionRepository txRepo;
    protected final ApplicationEventPublisher events;

    @Override
    public final Transaction execute(TransactionContext ctx) {
        validateAmount(ctx.amount());
        Account account = accountRepo.findWithLockById(ctx.accountId())
                .orElseThrow(() -> DomainException.notFound("Account not found"));
        Transaction tx = doExecute(account, ctx);
        Transaction saved = txRepo.save(tx);
        events.publishEvent(new TransactionEvent(saved, ctx.initiatedBy()));
        return saved;
    }

    protected abstract Transaction doExecute(Account account, TransactionContext ctx);

    protected void validateAmount(BigDecimal amount) {
        if (amount == null || amount.signum() <= 0) {
            throw DomainException.badRequest("Amount must be positive");
        }
    }

    protected Transaction buildTx(Account account, Account counterparty, TransactionType type,
                                  BigDecimal amount, String description, BigDecimal balanceAfter) {
        return Transaction.builder()
                .account(account)
                .counterpartyAccount(counterparty)
                .type(type)
                .status(TransactionStatus.SUCCESS)
                .amount(amount)
                .balanceAfter(balanceAfter)
                .description(description)
                .build();
    }
}
