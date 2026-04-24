package com.atm.bank.service;

import com.atm.bank.config.AppProperties;
import com.atm.bank.domain.Account;
import com.atm.bank.domain.Role;
import com.atm.bank.domain.User;
import com.atm.bank.dto.auth.AuthResponse;
import com.atm.bank.dto.auth.LoginRequest;
import com.atm.bank.dto.auth.RegisterRequest;
import com.atm.bank.event.LoginEvent;
import com.atm.bank.exception.DomainException;
import com.atm.bank.repository.UserRepository;
import com.atm.bank.security.JwtService;
import java.math.BigDecimal;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository users;
    private final PasswordEncoder encoder;
    private final JwtService jwt;
    private final AppProperties props;
    private final UserFileStore userFileStore;
    private final AccountNumberGenerator accountNumberGenerator;
    private final ApplicationEventPublisher events;

    @Transactional
    public AuthResponse register(RegisterRequest req) {
        if (users.existsByUsername(req.username())) {
            throw DomainException.conflict("Username already in use");
        }
        if (users.existsByEmail(req.email())) {
            throw DomainException.conflict("Email already in use");
        }

        User admin = users.findByRole(Role.ADMIN, org.springframework.data.domain.PageRequest.of(0, 1))
                .stream().findFirst()
                .orElseThrow(() -> DomainException.conflict("No admin is configured"));

        Account account = Account.builder()
                .accountNumber(accountNumberGenerator.generate())
                .balance(BigDecimal.ZERO)
                .build();

        User user = User.builder()
                .username(req.username())
                .email(req.email())
                .fullName(req.fullName())
                .passwordHash(encoder.encode(req.password()))
                .role(Role.CUSTOMER)
                .admin(admin)
                .build();
        account.setOwner(user);
        user.setAccount(account);

        User saved = users.save(user);
        userFileStore.append(saved);

        String token = jwt.issue(saved.getUsername(), Map.of(
                "uid", saved.getId(),
                "role", saved.getRole().name()));
        return new AuthResponse(token, saved.getId(), saved.getUsername(), saved.getFullName(), saved.getRole().name());
    }

    @Transactional(noRollbackFor = DomainException.class)
    public AuthResponse login(LoginRequest req, String ip) {
        User user = users.findByUsername(req.username())
                .orElseThrow(() -> DomainException.unauthorized("Invalid credentials"));

        if (user.isLocked()) {
            throw DomainException.locked("Account locked. Contact admin.");
        }

        if (!encoder.matches(req.password(), user.getPasswordHash())) {
            int attempts = user.getFailedAttempts() + 1;
            user.setFailedAttempts(attempts);
            if (attempts >= props.security().maxLoginAttempts()) {
                user.setLocked(true);
            }
            users.save(user);
            events.publishEvent(new LoginEvent(user.getId(), user.getUsername(), false, ip));
            if (user.isLocked()) {
                throw DomainException.locked("Account locked after too many failed attempts.");
            }
            throw DomainException.unauthorized("Invalid credentials");
        }

        user.setFailedAttempts(0);
        users.save(user);
        events.publishEvent(new LoginEvent(user.getId(), user.getUsername(), true, ip));

        String token = jwt.issue(user.getUsername(), Map.of(
                "uid", user.getId(),
                "role", user.getRole().name()));
        return new AuthResponse(token, user.getId(), user.getUsername(), user.getFullName(), user.getRole().name());
    }
}
