package com.atm.bank.controller;

import com.atm.bank.dto.common.PageResponse;
import com.atm.bank.dto.transaction.AmountRequest;
import com.atm.bank.dto.transaction.TransactionResponse;
import com.atm.bank.dto.transaction.TransferRequest;
import com.atm.bank.security.JwtAuthFilter.JwtPrincipal;
import com.atm.bank.service.AccountService;
import jakarta.validation.Valid;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final AccountService accounts;

    @GetMapping("/me")
    public ResponseEntity<Map<String, Object>> me(@AuthenticationPrincipal JwtPrincipal principal) {
        var user = accounts.requireUser(principal.id());
        BigDecimal balance = accounts.balance(principal.id());
        return ResponseEntity.ok(Map.of(
                "id", user.getId(),
                "username", user.getUsername(),
                "fullName", user.getFullName(),
                "email", user.getEmail(),
                "role", user.getRole().name(),
                "accountNumber", Optional.ofNullable(user.getAccount()).map(a -> a.getAccountNumber()).orElse(""),
                "balance", balance));
    }

    @PostMapping("/deposit")
    public ResponseEntity<TransactionResponse> deposit(@AuthenticationPrincipal JwtPrincipal principal,
                                                       @Valid @RequestBody AmountRequest req) {
        return ResponseEntity.ok(TransactionResponse.from(accounts.deposit(principal.id(), req.amount(), req.description())));
    }

    @PostMapping("/withdraw")
    public ResponseEntity<TransactionResponse> withdraw(@AuthenticationPrincipal JwtPrincipal principal,
                                                        @Valid @RequestBody AmountRequest req) {
        return ResponseEntity.ok(TransactionResponse.from(accounts.withdraw(principal.id(), req.amount(), req.description())));
    }

    @PostMapping("/transfer")
    public ResponseEntity<TransactionResponse> transfer(@AuthenticationPrincipal JwtPrincipal principal,
                                                        @Valid @RequestBody TransferRequest req) {
        return ResponseEntity.ok(TransactionResponse.from(
                accounts.transfer(principal.id(), req.targetAccountNumber(), req.amount(), req.description())));
    }

    @GetMapping("/transactions")
    public ResponseEntity<PageResponse<TransactionResponse>> history(@AuthenticationPrincipal JwtPrincipal principal,
                                                                     @PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(PageResponse.from(accounts.history(principal.id(), pageable), TransactionResponse::from));
    }
}
