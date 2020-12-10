package com.emysilva.springsecurityoauth2mysql;


import com.emysilva.springsecurityoauth2mysql.model.*;
import com.emysilva.springsecurityoauth2mysql.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;

import java.util.*;


@SpringBootApplication
public class SpringSecurityOauth2MysqlApplication {

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public static void main(String[] args) {

        SpringApplication.run(SpringSecurityOauth2MysqlApplication.class, args);
    }

    @Autowired
    public void AuthenticationManager(AuthenticationManagerBuilder builder, UsersRepository usersRepository) throws Exception {
        if (!usersRepository.findByName("user").isPresent()) {

            Users users = new Users();
            users.setEmail("user@gmail.com");
            users.setName("user");
            users.setPassword(passwordEncoder.encode("user"));
            users.setRoles(Set.of(new Role("USER")));
            usersRepository.save(users);
        }
        builder.userDetailsService(user -> new CustomUserDetails(usersRepository.findByName(user).get()));
    }

}
