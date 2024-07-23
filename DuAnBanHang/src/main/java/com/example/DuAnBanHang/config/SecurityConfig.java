package com.example.DuAnBanHang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

import javax.crypto.spec.SecretKeySpec;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    protected static final String KEY_SINGER = "ZNSMpt19M1W1J3plRQilQudB6AWMpZK6T6lcLJ4JjTtMBcKuUx";

    private final String[] PUBLIC_POST_ENDPOINTS = {"/user", "/authentication/token"};
    private final String[] PUBLIC_GET_ENDPOINTS = {"/user"};

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(request ->
                        request.requestMatchers(HttpMethod.POST, PUBLIC_POST_ENDPOINTS).permitAll()
//                        .requestMatchers(HttpMethod.GET, PUBLIC_GET_ENDPOINTS).hasAnyAuthority("SCOPE_Admin")
//                                .requestMatchers(HttpMethod.GET, PUBLIC_GET_ENDPOINTS).hasAnyAuthority("ROLE_Admin")
                                .anyRequest().authenticated()
        );
        httpSecurity.oauth2ResourceServer(request -> request.jwt(jwtConfigurer -> jwtConfigurer.decoder(jwtDecoder())));
        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        return httpSecurity.build();
    }

    @Bean
    JwtDecoder jwtDecoder() {
        SecretKeySpec secretKeySpec = new SecretKeySpec(KEY_SINGER.getBytes(), "HS256");
        return NimbusJwtDecoder
                .withSecretKey(secretKeySpec)
                .macAlgorithm(MacAlgorithm.HS256)
                .build();
    }

    @Bean
    JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtGrantedAuthoritiesConverter converter = new JwtGrantedAuthoritiesConverter();
        converter.setAuthorityPrefix("ROLE_");
        JwtAuthenticationConverter converter1 = new JwtAuthenticationConverter();
        converter1.setJwtGrantedAuthoritiesConverter(converter);
        return converter1;
    }
}
