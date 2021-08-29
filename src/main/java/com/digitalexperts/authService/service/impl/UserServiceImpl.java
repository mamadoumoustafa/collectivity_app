package com.digitalexperts.authService.service.impl;

import com.digitalexperts.authService.bo.User;
import com.digitalexperts.authService.repository.UserRepository;
import com.digitalexperts.authService.service.UserService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.digitalexperts.authService.service.exceptions.UserExceptions;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByNom(username);
    }

    @Override
    public User findByMail(String mail) {
        return userRepository.findByEmailEqualsIgnoreCase(mail);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

	@Override
	public void deleteUser(Long id) throws UserExceptions {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent())
		userRepository.delete(user.get());
		else throw new UserExceptions("Impossible de supprimer cet utilisateur.",new Date());
		//return "remove"+id;
	}

	@Override
	public User updateUser(User user) {
/*		User userExist=userRepository.findById(user.getId()).orElse(null);
		userExist.setNom(user.getNom());
		userExist.setPrenom(user.getPrenom());
		userExist.setEmail(user.getEmail());
		userExist.setTelephone(user.getTelephone());
		userExist.setNumCartCedeao(user.getNumCartCedeao());
		userExist.setNumCartElec(user.getNumCartElec());
		userExist.setRoles(user.getRoles());
		userExist.setPassword(user.getPassword());
		userExist.setCreateDateTime(user.getCreateDateTime());
		userExist.setCommune(user.getCommune());
		userExist.setUpdateDateTime(user.getUpdateDateTime());*/
		return userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
