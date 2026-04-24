package com.atm.bank.service;

import com.atm.bank.config.AppProperties;
import com.atm.bank.domain.User;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Instant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Persists user registration records to a CSV file (IO requirement).
 * Passwords are never written in plain form — only the BCrypt hash prefix marker.
 */
@Component
public class UserFileStore {

    private static final Logger log = LoggerFactory.getLogger(UserFileStore.class);
    private static final String HEADER = "timestamp,id,username,email,full_name,role,password_masked\n";

    private final Path filePath;

    public UserFileStore(AppProperties props) {
        this.filePath = Path.of(props.storage().usersFile());
        try {
            Path parent = filePath.getParent();
            if (parent != null) Files.createDirectories(parent);
            if (!Files.exists(filePath)) {
                Files.writeString(filePath, HEADER, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            }
        } catch (IOException e) {
            log.warn("Could not initialise users file at {}: {}", filePath, e.getMessage());
        }
    }

    public void append(User u) {
        String line = "%s,%d,%s,%s,%s,%s,%s%n".formatted(
                Instant.now(), u.getId(), u.getUsername(), u.getEmail(),
                u.getFullName(), u.getRole(), mask(u.getPasswordHash()));
        try {
            Files.writeString(filePath, line, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            log.warn("Could not write user {} to file: {}", u.getUsername(), e.getMessage());
        }
    }

    private static String mask(String hash) {
        if (hash == null || hash.length() < 8) return "****";
        return hash.substring(0, 4) + "****" + hash.substring(hash.length() - 4);
    }
}
