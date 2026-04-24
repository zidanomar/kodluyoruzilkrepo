package com.atm.bank.repository;

import com.atm.bank.domain.LoginAudit;
import java.time.Instant;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoginAuditRepository extends JpaRepository<LoginAudit, Long> {

    @EntityGraph(attributePaths = {"user"})
    Page<LoginAudit> findByUserIdOrderByLoggedInAtDesc(Long userId, Pageable pageable);

    @Query("""
            select distinct la.user.id from LoginAudit la
            where la.success = true and la.loggedInAt between :from and :to
            """)
    List<Long> findUserIdsSuccessfullyLoggedInBetween(Instant from, Instant to);
}
