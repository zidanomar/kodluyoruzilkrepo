package com.atm.bank.controller;

import com.atm.bank.dto.admin.CustomerResponse;
import com.atm.bank.dto.admin.LoginAuditResponse;
import com.atm.bank.dto.common.PageResponse;
import com.atm.bank.dto.transaction.TransactionResponse;
import com.atm.bank.service.AccountService;
import com.atm.bank.service.AdminService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService admin;
    private final AccountService accounts;

    @GetMapping("/customers")
    public ResponseEntity<PageResponse<CustomerResponse>> listCustomers(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(PageResponse.from(admin.listCustomers(pageable), CustomerResponse::from));
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<CustomerResponse> customer(@PathVariable Long id) {
        return ResponseEntity.ok(CustomerResponse.from(admin.customer(id)));
    }

    @GetMapping("/customers/{id}/transactions")
    public ResponseEntity<PageResponse<TransactionResponse>> customerTransactions(
            @PathVariable Long id, @PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(PageResponse.from(accounts.history(id, pageable), TransactionResponse::from));
    }

    @GetMapping("/customers/{id}/logins")
    public ResponseEntity<PageResponse<LoginAuditResponse>> customerLogins(
            @PathVariable Long id, @PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(PageResponse.from(admin.userLoginHistory(id, pageable), LoginAuditResponse::from));
    }

    @GetMapping("/customers/active-today")
    public ResponseEntity<List<Long>> customersActiveToday() {
        return ResponseEntity.ok(admin.customersLoggedInToday());
    }

    @PostMapping("/customers/{id}/unlock")
    public ResponseEntity<Void> unlock(@PathVariable Long id) {
        admin.unlock(id);
        return ResponseEntity.noContent().build();
    }
}
