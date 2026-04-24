package com.atm.bank.event;

public record LoginEvent(Long userId, String username, boolean success, String ip) {}
