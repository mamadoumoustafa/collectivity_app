package com.digitalexperts.authService.controllers;


import java.util.Date;
import java.util.Objects;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalexperts.authService.bo.User;
import com.digitalexperts.authService.service.UserService;
import com.digitalexperts.authService.service.exceptions.UserExceptions;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {


	private final UserService userService;
	private final PasswordEncoder encoder;


	private final Logger log = LoggerFactory.getLogger(AuthController.class);

	public AuthController(UserService userService, PasswordEncoder encoder) {
		this.userService = userService;
		this.encoder = encoder;
	}

/*

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		User user = userRepository.findByUsername(loginRequest.getUsername()).get();
		if(user != null)
		{
		log.info("user object: {}",user);

		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		log.info("roles : {}",roles);

		List<Role> roles1 = userRepository.findByUsername(loginRequest.getUsername()).get().getRoles();
		JwtResponse response = new JwtResponse(jwt,userDetails.getId(), userDetails.getFullname(), userDetails.getUsername(), userDetails.getPhoneNumber(),userDetails.getEnabled(),roles1);
		if(roles1.get(0).getName().equals(ERole.PARTENAIRE_ROLE))
			response.setBoutique(user.getBoutique());
                
		return ResponseEntity.ok(response);
		}
		return ResponseEntity.status(HttpStatus.OK).body("Veuillez revoir les identifiants saisis.");
	}
	 @PutMapping("/customer/{id}")
	  public ResponseEntity<?> updateCustomer(@PathVariable("id") long id, @Valid @RequestBody SignupRequest signUpRequest) {
		 

	    System.out.println("Update User with ID = " + id + "...");
	 
	    Optional<User> userData = userRepository.findById(id);
	 
	    if (userData.isPresent()) {
	       User _user = userData.get();
	      _user .setFullname(signUpRequest.getFullname());
	      _user .setUsername(signUpRequest.getUsername());
	      _user .setPhoneNumber(signUpRequest.getPhoneNumber());
	      _user .setPassword(encoder.encode(signUpRequest.getPassword()));
	     
	      return new ResponseEntity<>(userRepository.save(_user ), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
*/

	@PostMapping("/signup")
	public ResponseEntity<User> registerUser(@Valid @RequestBody User user) throws UserExceptions {

		log.info("Registering user with infos : {}",user);

		//Verifier si un utilisateur avec le meme mail existe

		if(Objects.isNull(userService.findByMail(user.getEmail()))){
			//On enregistre lutilisateur
			user.setPassword(encoder.encode(user.getPassword()));
			return ResponseEntity.ok(userService.save(user));
		}

		//cela veut dire kun utilisateur avec le mm usernamme existe
		throw new  UserExceptions("Un utilisateur avec les meme infos existe déja",new Date());
	}

/*	@GetMapping("/roles")
	public ResponseEntity<List<Role>> roles() {

		log.info("requesting all roles...");

		List<Role> roles = roleRepository.findAll();

		log.info("Roles : {}",roles);
		return ResponseEntity.ok(roles);
	}


	 @GetMapping("accountVerification/{token}")
	    public ResponseEntity<?> verifyAccount(@PathVariable String token) {
	    	System.out.println("one vrification methode");
	        authservice.verifyAccount(token);
	        return ResponseEntity.ok(new MessageResponse("Activated successfully!"));
	}

	*/
}
