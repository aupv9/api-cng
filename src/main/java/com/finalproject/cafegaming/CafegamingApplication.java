package com.finalproject.cafegaming;

import com.finalproject.cafegaming.model.EntityAuditing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
@EnableMongoAuditing
public class CafegamingApplication {

    public static void main(String[] args) {
        SpringApplication.run(CafegamingApplication.class, args);
    }
    @Bean
    public AuditorAware<String> auditorAware(){
        return new EntityAuditing();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
