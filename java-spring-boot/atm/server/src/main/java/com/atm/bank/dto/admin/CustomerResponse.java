package com.atm.bank.dto.admin;

import com.atm.bank.domain.User;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Optional;

public record CustomerResponse(
        Long id,
        String username,
        String email,
        String fullName,
        String accountNumber,
        BigDecimal balance,
        boolean locked,
        int failedAttempts,
        Instant createdAt) {

    public static CustomerResponse from(User u) {
        var account = Optional.ofNullable(u.getAccount());
        return new CustomerResponse(
                u.getId(),
                u.getUsername(),
                u.getEmail(),
                u.getFullName(),
                account.map(a -> a.getAccountNumber()).orElse(null),
                account.map(a -> a.getBalance()).orElse(BigDecimal.ZERO),
                u.isLocked(),
                u.getFailedAttempts(),
                u.getCreatedAt());
    }
}
