package com.example.securityapp.config;

import com.example.securityapp.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserServiceImpl userServiceImpl;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
//        webSecurity.ignoring().requestMatchers("/register");
        return httpSecurity
                .csrf().disable()
                .formLogin(Customizer.withDefaults())
                .authorizeHttpRequests(req -> req
                        .requestMatchers("/register/**")
                        .permitAll()
                        .requestMatchers("/login/**")
                        .permitAll()
                        .requestMatchers("/admin/**")
                        .hasAuthority("admin")
                        .requestMatchers("/user-login/**")
                        .hasAnyAuthority("user", "admin")
                        .anyRequest()
                        .authenticated()
                        )
                .userDetailsService(userServiceImpl)
                .build();

    }




}
