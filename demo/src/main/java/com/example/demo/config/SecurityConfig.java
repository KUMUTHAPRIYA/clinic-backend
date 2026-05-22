package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http
    ) throws Exception {

        http

            // Disable CSRF
            .csrf(csrf -> csrf.disable())

            // Enable CORS
            .cors(cors -> {})

            // Authorization
            .authorizeHttpRequests(auth -> auth

                .requestMatchers(
                        "/auth/**"
                ).permitAll()

                .anyRequest().permitAll()

            )

            // Disable Login Form
            .formLogin(form -> form.disable());

        return http.build();
    }
}