package com.digitalexperts.authService.repository;

import com.digitalexperts.authService.bo.Account;
import com.digitalexperts.authService.bo.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserJpaRepository extends JpaRepository<Account, Long> {
    Account findByUsername(String name);

    Boolean existsByUsername(String username);

    List<Account> findAllByRolesContains(Role role);
    Page<Account> findAllByRolesContains(Role role, Pageable pageable);


    @Query("select u from Account u where u.username = ?1")
    Account findAccountByUsername(String name);

}
