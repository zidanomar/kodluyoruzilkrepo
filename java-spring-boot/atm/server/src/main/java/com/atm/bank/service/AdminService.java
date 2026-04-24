package com.atm.bank.service;

import com.atm.bank.domain.LoginAudit;
import com.atm.bank.domain.Role;
import com.atm.bank.domain.User;
import com.atm.bank.exception.DomainException;
import com.atm.bank.repository.LoginAuditRepository;
import com.atm.bank.repository.UserRepository;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final UserRepository users;
    private final LoginAuditRepository loginAudit;

    @Transactional(readOnly = true)
    public Page<User> listCustomers(Pageable pageable) {
        return users.findWithAccountByRole(Role.CUSTOMER, pageable);
    }

    @Transactional(readOnly = true)
    public User customer(Long id) {
        User u = users.findById(id).orElseThrow(() -> DomainException.notFound("Customer not found"));
        if (u.getRole() != Role.CUSTOMER) {
            throw DomainException.badRequest("User is not a customer");
        }
        return u;
    }

    @Transactional(readOnly = true)
    public List<Long> customersLoggedInToday() {
        LocalDate today = LocalDate.now(ZoneOffset.UTC);
        Instant from = today.atStartOfDay(ZoneOffset.UTC).toInstant();
        Instant to = today.plusDays(1).atStartOfDay(ZoneOffset.UTC).toInstant();
        return loginAudit.findUserIdsSuccessfullyLoggedInBetween(from, to);
    }

    @Transactional(readOnly = true)
    public Page<LoginAudit> userLoginHistory(Long userId, Pageable pageable) {
        return loginAudit.findByUserIdOrderByLoggedInAtDesc(userId, pageable);
    }

    @Transactional
    public void unlock(Long userId) {
        User u = customer(userId);
        u.setLocked(false);
        u.setFailedAttempts(0);
        users.save(u);
    }
}
