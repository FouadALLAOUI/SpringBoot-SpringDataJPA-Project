package com.fouad.exemple;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // The spring boot will scan all the beans in the configuration class
public class ApplicationConfig {

    @Bean  // Transform Class to Bean
    @Qualifier("bean1")
    public MyFirstClass myFirstBean(){
        return new  MyFirstClass("First Bean");
    }

    @Bean  // Transform Class to Bean
    @Qualifier("bean2")
    public MyFirstClass mySecondBean(){
        return new  MyFirstClass("Second Bean");
    }

}
