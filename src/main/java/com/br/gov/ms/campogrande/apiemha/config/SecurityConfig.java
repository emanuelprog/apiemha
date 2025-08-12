package com.br.gov.ms.campogrande.apiemha.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        .requestMatchers(HttpMethod.GET,
                                "/commercial-module",
                                "/contract/filter",
                                "/debt/contract",
                                "/event",
                                "/housing-complexes",
                                "/housing-complexes/commercial-module",
                                "/inscription/person-online",
                                "/debt/extract",
                                "/chart",
                                "/profession",
                                "/deficiency",
                                "/event-component/event"
                        ).permitAll()
                        .requestMatchers(HttpMethod.POST,
                                "/person-online/registered",
                                "/person/benefiteds",
                                "/person-online/second-copy",
                                "/debt/second-copy",
                                "/debt/slip"
                        ).permitAll()
                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer(oauth2 -> oauth2.jwt())
                .build();
    }
}
