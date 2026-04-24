package com.atm.bank.event;

import com.atm.bank.domain.LoginAudit;
import com.atm.bank.repository.LoginAuditRepository;
import com.atm.bank.repository.UserRepository;
import java.time.Instant;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Observer pattern: subscribes to domain events and logs them + persists login audit.
 */
@Component
@RequiredArgsConstructor
public class AuditListener {

    private static final Logger log = LoggerFactory.getLogger(AuditListener.class);

    private final LoginAuditRepository loginAuditRepo;
    private final UserRepository userRepo;

    @EventListener
    public void onTransaction(TransactionEvent ev) {
        var tx = ev.transaction();
        log.info("TX id={} type={} status={} amount={} account={} by={}",
                tx.getId(), tx.getType(), tx.getStatus(), tx.getAmount(),
                tx.getAccount().getAccountNumber(), ev.initiatedBy());
    }

    @EventListener
    @Transactional
    public void onLogin(LoginEvent ev) {
        log.info("LOGIN user={} success={} ip={}", ev.username(), ev.success(), ev.ip());
        userRepo.findById(ev.userId()).ifPresent(u ->
                loginAuditRepo.save(LoginAudit.builder()
                        .user(u)
                        .success(ev.success())
                        .loggedInAt(Instant.now())
                        .ipAddress(ev.ip())
                        .build()));
    }
}
