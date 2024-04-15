package com.fouad.exemple;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // The spring boot will scan all the beans in the configuration class
public class ApplicationConfig {
    @Bean("myBean")  // Transform Class to Bean
    public MyFirstClass myFirstClass(){
        return new  MyFirstClass();
    }
}
