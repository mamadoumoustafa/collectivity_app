package com.digitalexperts.authService.service.impl;

import com.digitalexperts.authService.bo.Account;
import com.digitalexperts.authService.bo.Role;
import com.digitalexperts.authService.repository.AccountRepository;
import com.digitalexperts.authService.service.AccountService;
import com.digitalexperts.authService.service.exceptions.UserExceptions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class AccountServiceImpl implements AccountService, UserDetailsService {

private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account save(Account a) {
        return accountRepository.save(a);
    }

    @Override
    public Account findByUsername(String name) {
        return accountRepository.findAccountByUsername(name);
    }


    @Override
    public Account findById(Long id) throws UserExceptions {
        if (accountRepository.findById(id) == null)
            throw new UserExceptions("User with " + id + "not found",new Date());
        else
            return accountRepository.findById(id).get();
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return accountRepository.findAccountByUsername(s);

    }
}
