package com.digitalexperts.authService.config;

import com.digitalexperts.authService.service.AccountService;
import com.digitalexperts.authService.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Autowired
    private AccountServiceImpl accountService;

    @Bean
    public AuthenticationManager getAuthenticationManager() throws Exception {
        return super.authenticationManager();
    }

    protected void configure(HttpSecurity http) throws Exception {
       /* http.authorizeRequests().antMatchers("/api/accounts/**").permitAll()
                .anyRequest().authenticated().and().formLogin()*/
        //    .and().cors().and().csrf().disable().authorizeRequests()
        ;


        http.authorizeRequests().antMatchers("/**").permitAll();

    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(accountService).passwordEncoder(passwordEncoder);
    }
}
