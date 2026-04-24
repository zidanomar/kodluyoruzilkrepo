package com.atm.bank.service.factory;

import com.atm.bank.domain.TransactionType;
import com.atm.bank.exception.DomainException;
import com.atm.bank.service.strategy.TransactionStrategy;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

/**
 * Factory: resolves the correct strategy for a requested TransactionType.
 * Strategies are auto-registered via Spring's bean injection.
 */
@Component
public class TransactionStrategyFactory {

    private final Map<TransactionType, TransactionStrategy> registry;

    public TransactionStrategyFactory(List<TransactionStrategy> strategies) {
        this.registry = strategies.stream()
                .collect(Collectors.toUnmodifiableMap(TransactionStrategy::supports, Function.identity()));
    }

    public TransactionStrategy strategyFor(TransactionType type) {
        TransactionStrategy s = registry.get(type);
        if (s == null) {
            throw DomainException.badRequest("Unsupported transaction type: " + type);
        }
        return s;
    }
}
