package com.digitalexperts.authService.service;

import com.digitalexperts.authService.bo.Account;
import com.digitalexperts.authService.bo.Role;
import com.digitalexperts.authService.service.exceptions.UserExceptions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface UserService {

    Account saveAccount(Account pAccount);

    Account findByUsername(String name);

    Account findById(Long id) throws UserExceptions;

    List<Account> findAccountsByRole(Role role);
    Page<Account> findAccountsByRole(Role role, Pageable pageable);

    void deleteAccount(Account pAccount);

    Boolean existsByUsername(String username);

    List<Account> findAll();
    List<Account> saveAll(List<Account> accounts);
    void deleteAll();

}
