package com.digitalexperts.authService.repository;

import com.digitalexperts.authService.bo.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    Account findAccountByUsername(String u);

}
