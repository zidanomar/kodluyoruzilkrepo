package com.atm.bank.config;

import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
public record AppProperties(Security security, Storage storage, Cors cors) {

    public record Security(Jwt jwt, int maxLoginAttempts) {
        public record Jwt(String secret, long expirationMinutes) {}
    }

    public record Storage(String usersFile) {}

    public record Cors(List<String> allowedOrigins) {}
}
