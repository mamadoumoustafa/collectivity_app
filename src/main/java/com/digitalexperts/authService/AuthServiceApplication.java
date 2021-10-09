package com.digitalexperts.authService;

import com.digitalexperts.authService.bo.Role;
import com.digitalexperts.authService.repository.RoleRepository;
import com.digitalexperts.authService.utils.RoleConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AuthServiceApplication implements CommandLineRunner {

	@Autowired
	RoleRepository roleRepository;



	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

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
	//	roleRepository.save(r1);
	//	roleRepository.save(r2);
	}
}
