package com.digitalexperts.authService.service.impl;

import com.digitalexperts.authService.bo.Membre;
import com.digitalexperts.authService.repository.MemberRepository;
import com.digitalexperts.authService.service.MemberService;
import com.digitalexperts.authService.service.exceptions.UserExceptions;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

@Service
public class MemberServiceImpl  implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Membre findIfExists(String nom, String prenom, String tel) {
        return memberRepository.findDistinctByNomAndPrenomAndTelephone(nom, prenom, tel);
    }

    @Override
    public Membre save(Membre membre) throws UserExceptions {
        if (Objects.isNull(findIfExists(membre.getNom(), membre.getPrenom(), membre.getTelephone()))) {
            // Il n'y a aucun membre avec ces infos
          return   memberRepository.save(membre);
        } else throw new UserExceptions("Un utilisateur avec ces infos est déja enregistré", new Date());
    }

    @Override
    public Membre update(Membre membre) {
        return null;
    }
}
