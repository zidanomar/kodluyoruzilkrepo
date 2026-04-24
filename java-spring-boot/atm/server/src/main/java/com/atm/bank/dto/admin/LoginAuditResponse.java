package com.atm.bank.dto.admin;

import com.atm.bank.domain.LoginAudit;
import java.time.Instant;

public record LoginAuditResponse(Long id, Long userId, String username, boolean success, Instant loggedInAt, String ipAddress) {

    public static LoginAuditResponse from(LoginAudit la) {
        return new LoginAuditResponse(la.getId(), la.getUser().getId(), la.getUser().getUsername(),
                la.isSuccess(), la.getLoggedInAt(), la.getIpAddress());
    }
}
