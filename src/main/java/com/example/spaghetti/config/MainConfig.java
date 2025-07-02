package com.example.spaghetti.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Predicate;

@Configuration
public class MainConfig {

    @Bean
    public Predicate<String> nameStartsWithUppercaseValidator() {
        return name -> name != null && !name.isEmpty() && Character.isUpperCase(name.charAt(0));
    }
}