package com.digitalexperts.authService.repository;

import com.digitalexperts.authService.bo.Membre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository  extends JpaRepository<Membre,Long> {

    Membre findDistinctByNomAndPrenomAndTelephone(String name,String prenom,String tel);
}
