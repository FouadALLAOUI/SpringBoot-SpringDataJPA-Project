package com.fouad.exemple;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // The spring boot will scan all the beans in the configuration class
public class ApplicationConfig {
    @Bean  // Transform Class to Bean
    public MyFirstClass myFirstBean(){
        return new  MyFirstClass("First Bean");
    }
}
