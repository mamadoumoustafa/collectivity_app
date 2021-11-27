package com.digitalexperts.authService.controllers;

import com.digitalexperts.authService.bo.Account;
import com.digitalexperts.authService.bo.Membre;
import com.digitalexperts.authService.service.AccountService;
import com.digitalexperts.authService.service.IRoleService;
import com.digitalexperts.authService.service.MemberService;
import com.digitalexperts.authService.service.UserService;
import com.digitalexperts.authService.service.exceptions.UserExceptions;
import com.digitalexperts.authService.utils.RoleConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api/user/")
public class UserController {

	private UserService userService;


	private final AccountService accountService;

	private final MemberService memberService;

	private final BCryptPasswordEncoder passwordEncoder;
	private final IRoleService roleService;


	private final Logger log = LoggerFactory.getLogger(UserController.class);


	public UserController(UserService userService, AccountService accountService, MemberService memberService, BCryptPasswordEncoder passwordEncoder, IRoleService roleService) {
		super();
		this.userService = userService;
		this.accountService = accountService;
		this.memberService = memberService;
		this.passwordEncoder = passwordEncoder;
		this.roleService = roleService;
	}
	
	@PostMapping("/mew-member")
	public ResponseEntity<Membre> addNewMember(@RequestBody @Valid Membre membre) throws UserExceptions {

		log.info("request to add new member : {}",membre);

		if(Objects.isNull(membre.getId()) && Objects.isNull(memberService.findIfExists(membre.getNom(),membre.getPrenom(),membre.getTelephone()))){

			//créer un compte


			Account account = new Account();

			account.setUsername(membre.getTelephone());
			account.setPassword(passwordEncoder.encode(membre.getPassword()));
			account.setEnabled(Boolean.TRUE);

			account.getRoles().add(roleService.findByName("User"));

				//Enregistrer l'utilisateur

				try {

					log.info("adding account : {}",account);
					accountService.save(account);

					log.info("saving member : {}",membre);
					memberService.save(membre);

				} catch (Exception e) {
					log.warn("error while saving user");
				}

				return ResponseEntity.ok(membre);

			}
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

