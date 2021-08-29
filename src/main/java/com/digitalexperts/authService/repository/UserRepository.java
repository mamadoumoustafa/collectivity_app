package com.digitalexperts.authService.repository;

import com.digitalexperts.authService.bo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByNom(String usr);
    User findByEmailEqualsIgnoreCase(String usr);
}
