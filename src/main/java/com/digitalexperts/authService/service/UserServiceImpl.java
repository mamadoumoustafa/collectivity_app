package com.digitalexperts.authService.service;


import com.digitalexperts.authService.bo.Account;
import com.digitalexperts.authService.bo.Role;
import com.digitalexperts.authService.bo.User;
import com.digitalexperts.authService.repository.UserJpaRepository;
import com.digitalexperts.authService.repository.UserRepository;
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
public class UserServiceImpl implements UserService {

    private final UserRepository userdao;

    public UserServiceImpl(UserRepository userdao) {
        this.userdao = userdao;
    }


    @Override
    public User save(User user) throws Exception{
        return userdao.save(user);
    }

    @Override
    public User findByName(String name) {
        return null;
    }

    @Override
    public User checkIfExist(String nom, String prenom, String tel) {
        return userdao.findDistinctByNomAndPrenomAndTelephone(nom,prenom,tel);
    }

    @Override
    public List<User> findAll() {
        return null;
    }

}
