package com.digitalexperts.authService.service;

import com.digitalexperts.authService.bo.Account;
import com.digitalexperts.authService.service.exceptions.UserExceptions;

import java.util.List;

public interface AccountService {

    Account save(Account a);
    Account findByUsername(String u);
    Account findById(Long id) throws UserExceptions;

    List<Account> findAll();
}
