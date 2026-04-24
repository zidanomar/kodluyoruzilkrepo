package com.atm.bank.dto.transaction;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

public record AmountRequest(
        @NotNull @DecimalMin(value = "0.01", message = "amount must be positive")
        @Digits(integer = 17, fraction = 2) BigDecimal amount,
        @Size(max = 255) String description) {}
