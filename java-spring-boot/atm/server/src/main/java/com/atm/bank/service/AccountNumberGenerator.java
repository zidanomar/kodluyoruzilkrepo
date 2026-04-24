package com.atm.bank.service;

import java.security.SecureRandom;
import org.springframework.stereotype.Component;

@Component
public class AccountNumberGenerator {

    private static final SecureRandom RNG = new SecureRandom();

    public String generate() {
        StringBuilder sb = new StringBuilder("TR");
        for (int i = 0; i < 16; i++) {
            sb.append(RNG.nextInt(10));
        }
        return sb.toString();
    }
}
