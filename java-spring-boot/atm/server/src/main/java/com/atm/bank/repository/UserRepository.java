package com.atm.bank.repository;

import com.atm.bank.domain.Role;
import com.atm.bank.domain.User;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    Page<User> findByRole(Role role, Pageable pageable);

    @Query("""
            select u from User u
            left join fetch u.account a
            where u.role = :role
            """)
    Page<User> findWithAccountByRole(Role role, Pageable pageable);
}
