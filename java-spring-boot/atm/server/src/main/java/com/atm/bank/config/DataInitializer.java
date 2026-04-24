package com.atm.bank.config;

import com.atm.bank.domain.Role;
import com.atm.bank.domain.User;
import com.atm.bank.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DataInitializer.class);

    private final UserRepository users;
    private final PasswordEncoder encoder;

    @Override
    public void run(String... args) {
        if (users.existsByUsername("admin")) return;
        User admin = User.builder()
                .username("admin")
                .email("admin@atm.local")
                .fullName("System Admin")
                .passwordHash(encoder.encode("admin123"))
                .role(Role.ADMIN)
                .build();
        users.save(admin);
        log.info("Seeded default admin account (username=admin, password=admin123)");
    }
}
