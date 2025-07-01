package com.example.spaghetti;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig {

    @Bean
    public String uselessBean() {
        return "I am a useless bean";
    }
}