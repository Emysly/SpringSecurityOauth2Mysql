package com.emysilva.springsecurityoauth2mysql.config;

import com.emysilva.springsecurityoauth2mysql.service.*;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.oauth2.config.annotation.web.configuration.*;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.headers()
                .frameOptions().disable()
                .and()
                .authorizeRequests().antMatchers("/", "/home", "register", "/login").permitAll()
                .antMatchers("/rest/**").authenticated();
    }
}