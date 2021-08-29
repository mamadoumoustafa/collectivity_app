package com.digitalexperts.authService.controllers;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.digitalexperts.authService.service.exceptions.UserExceptions;
import com.digitalexperts.authService.utils.RoleConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitalexperts.authService.bo.User;
import com.digitalexperts.authService.service.UserService;

import javax.validation.Valid;

@RestController
public class UserController {
	private UserService userService;

	private final Logger log = LoggerFactory.getLogger(UserController.class);


	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("/adduser")
	public ResponseEntity<User> toAddUser(@RequestBody @Valid User user) throws UserExceptions {
		log.info("request to add new user : {}",user);
		if(Objects.isNull(user.getId()))
		 return ResponseEntity.ok(userService.save(user));
		else
			throw new UserExceptions("Il ne s\'agit pas d\'un nouveau utilisateur.",new Date());
	}
	
	@GetMapping("/users")
	@PreAuthorize("hasRole(\"" + RoleConstants.ADMIN + "\")")
	public ResponseEntity<List<User>> listeUsers() {
		log.info("retrieving all users...");
		return ResponseEntity.ok(userService.findAll());
	}
	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole(\"" + RoleConstants.ADMIN + "\")")
	public ResponseEntity<Void> supression(@RequestParam Long id) throws UserExceptions {
		log.warn("deleting user with id : {}",id);
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/update")
	public ResponseEntity<User> updatUser(@RequestBody @Valid User user) {
		log.info("updating user with infos : {}",user);
		 return ResponseEntity.ok(userService.updateUser(user));
	}
}

