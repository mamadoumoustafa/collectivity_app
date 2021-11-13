package com.digitalexperts.authService.service;


import com.digitalexperts.authService.bo.Account;
import com.digitalexperts.authService.bo.Role;
import com.digitalexperts.authService.repository.UserJpaRepository;
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
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserJpaRepository userdao;

    public UserServiceImpl(UserJpaRepository userdao) {
        this.userdao = userdao;
    }

    @Override
    public Account saveAccount(Account pAccount) {
        return userdao.save(pAccount);
    }

    @Override
    public Account findByUsername(String name) {
        return userdao.findAccountByUsername(name);
    }


    @Override
    public Account findById(Long id) throws UserExceptions {
        if (userdao.findById(id) == null)
            throw new UserExceptions("User with " + id + "not found",new Date());
        else
            return userdao.findById(id).get();
    }

    @Override
    public List<Account> findAccountsByRole(Role role) {
        return userdao.findAllByRolesContains(role);
    }

    @Override
    public Page<Account> findAccountsByRole(Role role, Pageable pageable) {
        return userdao.findAllByRolesContains(role,pageable);

    }

/*    @Override
    public Account updateAccount(Account pAccount) throws UserExceptions {
        Account account = userdao.findById(pAccount.getId()).get();
        if (account == null)
            throw new UserExceptions("User with username "+pAccount.getUsername()+"not found");
        else {
            account.setUsername(pAccount.getUsername());
            account.setPassword(pAccount.getPassword());
        }

        return userdao.saveAndFlush(account);
    }*/


    @Override
    public void deleteAccount(Account pAccount) {
        userdao.delete(pAccount);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userdao.existsByUsername(username);
    }

    @Override
    public List<Account> findAll() {
        return userdao.findAll();
    }

    @Override
    public List<Account> saveAll(List<Account> accounts) {
        return userdao.saveAll(accounts);
    }

    @Override
    public void deleteAll() {
        userdao.deleteAll();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userdao.findByUsername(s);
    }
}
