package com.digitalexperts.authService.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer

public class AuthorizationServer implements AuthorizationServerConfigurer {


    private final BCryptPasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

   // @Qualifier("getTokenStore")
    private final TokenStore tokenStore;

    private final int validity = 60 * 60 * 24 * 30;

    public AuthorizationServer(BCryptPasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, TokenStore tokenStore) {
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenStore = tokenStore;
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        clients.inMemory().withClient("Auth-client")
                .secret(passwordEncoder.encode("Auth-client-secret"))
                .authorizedGrantTypes("password", "refresh_token")
                .scopes("user").accessTokenValiditySeconds(3600)
                .refreshTokenValiditySeconds(validity);

    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        endpoints.authenticationManager(authenticationManager);
        endpoints.tokenStore(tokenStore);

    }
}
