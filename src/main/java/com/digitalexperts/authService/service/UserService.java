package com.digitalexperts.authService.service;

import com.digitalexperts.authService.bo.User;

import java.util.List;


public interface UserService {

    User save (User user) throws Exception;

    User findByName(String name);

    User checkIfExist(String nom,String prenom,String tel);

    List<User> findAll();


}
