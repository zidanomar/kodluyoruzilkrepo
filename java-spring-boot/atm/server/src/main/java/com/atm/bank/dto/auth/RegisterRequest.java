package com.atm.bank.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
        @NotBlank @Size(min = 3, max = 64)
        @Pattern(regexp = "^[a-zA-Z0-9_.-]+$", message = "username may only contain letters, digits, _ . -")
        String username,

        @NotBlank @Email @Size(max = 128) String email,

        @NotBlank @Size(min = 2, max = 128) String fullName,

        @NotBlank @Size(min = 6, max = 72) String password
) {}
