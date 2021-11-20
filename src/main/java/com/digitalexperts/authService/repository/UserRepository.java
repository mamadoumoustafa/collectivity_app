package com.digitalexperts.authService.repository;

import com.digitalexperts.authService.bo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByNom(String usr);
    User findDistinctByNomAndPrenomAndTelephone(String nom,String prenom,String tel);
    User findByEmailEqualsIgnoreCase(String usr);
}
