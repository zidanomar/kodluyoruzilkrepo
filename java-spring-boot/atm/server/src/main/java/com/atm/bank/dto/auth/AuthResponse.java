package com.atm.bank.dto.auth;

public record AuthResponse(String token, Long userId, String username, String fullName, String role) {}
