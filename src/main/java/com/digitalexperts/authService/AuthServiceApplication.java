package com.digitalexperts.authService;

import com.digitalexperts.authService.bo.Account;
import com.digitalexperts.authService.bo.Role;
import com.digitalexperts.authService.repository.RoleRepository;
import com.digitalexperts.authService.service.IRoleService;
import com.digitalexperts.authService.service.UserService;
import com.digitalexperts.authService.utils.RoleConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import java.util.Objects;

@SpringBootApplication
@EnableResourceServer
@EnableGlobalMethodSecurity(securedEnabled = true)

public class AuthServiceApplication implements CommandLineRunner {

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	private IRoleService roleService;

	@Autowired
	UserService userService;



	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Role r1 = new Role();
		Role r2 = new Role();
		r1.setNom(RoleConstants.USER);
		r2.setNom(RoleConstants.ADMIN);

		// A commenter apres le premier démarrage
//		roleRepository.save(r1);
//		roleRepository.save(r2);


		Account account = new Account();

		account.setUsername("ngorfaye");
		account.setEnabled(Boolean.TRUE);
		account.setPassword(passwordEncoder().encode("123456"));
		account.getRoles().add(roleService.findByName("Admin"));

		//  log.info("saving ngor faye...");
/*		if (Objects.isNull(userService.findByUsername("ngorfaye")))
			userService.saveAccount(account);*/


	}

	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	TokenStore getTokenStore() {
		return new InMemoryTokenStore();
	}
}
