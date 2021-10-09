package com.digitalexperts.authService.service;

import java.util.List;

import com.digitalexperts.authService.bo.User;
import com.digitalexperts.authService.service.exceptions.UserExceptions;

public interface UserService {
	User findById(Long id);
    User findByUsername(String username);
  //  User findByMail(String mail);
    User save(User user);
	public void deleteUser(Long id) throws UserExceptions;
	public User updateUser(User user);
	public List<User> findAll();


}
