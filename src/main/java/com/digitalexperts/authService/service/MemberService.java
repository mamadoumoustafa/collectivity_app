package com.digitalexperts.authService.service;

import com.digitalexperts.authService.bo.Membre;
import com.digitalexperts.authService.service.exceptions.UserExceptions;

public interface MemberService {

    Membre findIfExists(String nom,String prenom,String tel);
    Membre save(Membre membre) throws UserExceptions;
    Membre update(Membre membre);
}
