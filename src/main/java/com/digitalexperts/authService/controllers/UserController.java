package com.digitalexperts.authService.controllers;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.digitalexperts.authService.bo.Account;
import com.digitalexperts.authService.service.AccountService;
import com.digitalexperts.authService.service.exceptions.UserExceptions;
import com.digitalexperts.authService.utils.RoleConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.digitalexperts.authService.bo.User;
import com.digitalexperts.authService.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("api/user/")
public class UserController {

	private UserService userService;


	private final AccountService accountService;

	private final BCryptPasswordEncoder passwordEncoder;

	private final Logger log = LoggerFactory.getLogger(UserController.class);


	public UserController(UserService userService, AccountService accountService, BCryptPasswordEncoder passwordEncoder) {
		super();
		this.userService = userService;
		this.accountService = accountService;
		this.passwordEncoder = passwordEncoder;
	}
	
	@PostMapping("/adduser")
	public ResponseEntity<User> toAddUser(@RequestBody @Valid User user) throws UserExceptions {

		log.info("request to add new user : {}",user);
		if(Objects.isNull(user.getId()) && Objects.isNull(userService.checkIfExist(user.getNom()
		,user.getPrenom(),user.getTelephone()))){

			//Enregistrer l'utilisateur

			try {
				user = userService.save(user);

				//créer un compte

				Account account = new Account();

				account.setUsername(user.getTelephone());
				account.setPassword(passwordEncoder.encode(user.getPassword()));
				account.setEnabled(Boolean.TRUE);

				accountService.save(account);



			} catch (Exception e) {
				log.warn("error while saving user");
			}

			return ResponseEntity.ok(user);

		}
		//* return ResponseEntity.ok(userService.save(user));
		else
			throw new UserExceptions("Il ne s\'agit pas d\'un nouveau utilisateur.",new Date());
	}


	@GetMapping("/users")
	@PreAuthorize("hasRole(\"" + RoleConstants.ADMIN + "\")")
	public ResponseEntity<List<Account>> listeUsers() {
		log.info("retrieving all users...");
		return ResponseEntity.ok(accountService.findAll());
	}
	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole(\"" + RoleConstants.ADMIN + "\")")
	public ResponseEntity<Void> supression(@RequestParam Long id) throws UserExceptions {
		log.warn("deleting user with id : {}",id);
		//userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}

/*	@PutMapping("/update")
	public ResponseEntity<User> updatUser(@RequestBody @Valid User user) {
		log.info("updating user with infos : {}",user);
		 return ResponseEntity.ok(userService.updateUser(user));
	}*/
}

