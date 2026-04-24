package com.atm.bank.service;

import com.atm.bank.domain.Transaction;
import com.atm.bank.domain.TransactionType;
import com.atm.bank.domain.User;
import com.atm.bank.exception.DomainException;
import com.atm.bank.repository.AccountRepository;
import com.atm.bank.repository.TransactionRepository;
import com.atm.bank.repository.UserRepository;
import com.atm.bank.service.factory.TransactionStrategyFactory;
import com.atm.bank.service.strategy.TransactionContext;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final UserRepository users;
    private final AccountRepository accounts;
    private final TransactionRepository transactions;
    private final TransactionStrategyFactory strategyFactory;

    @Transactional(readOnly = true)
    public User requireUser(Long userId) {
        return users.findById(userId).orElseThrow(() -> DomainException.notFound("User not found"));
    }

    @Transactional(readOnly = true)
    public BigDecimal balance(Long userId) {
        return accounts.findByOwnerId(userId)
                .orElseThrow(() -> DomainException.notFound("Account not found"))
                .getBalance();
    }

    @Transactional(readOnly = true)
    public Page<Transaction> history(Long userId, Pageable pageable) {
        var account = accounts.findByOwnerId(userId)
                .orElseThrow(() -> DomainException.notFound("Account not found"));
        return transactions.findByAccountIdOrderByCreatedAtDesc(account.getId(), pageable);
    }

    @Transactional
    public Transaction deposit(Long userId, BigDecimal amount, String description) {
        return run(userId, TransactionType.DEPOSIT, null, amount, description);
    }

    @Transactional
    public Transaction withdraw(Long userId, BigDecimal amount, String description) {
        return run(userId, TransactionType.WITHDRAW, null, amount, description);
    }

    @Transactional
    public Transaction transfer(Long userId, String targetAccountNumber, BigDecimal amount, String description) {
        return run(userId, TransactionType.TRANSFER_OUT, targetAccountNumber, amount, description);
    }

    private Transaction run(Long userId, TransactionType type, String counterparty, BigDecimal amount, String description) {
        var account = accounts.findByOwnerId(userId)
                .orElseThrow(() -> DomainException.notFound("Account not found"));
        var ctx = new TransactionContext(account.getId(), counterparty, amount, description, userId);
        return strategyFactory.strategyFor(type).execute(ctx);
    }
}
