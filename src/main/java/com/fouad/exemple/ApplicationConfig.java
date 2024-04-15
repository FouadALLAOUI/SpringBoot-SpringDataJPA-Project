package com.fouad.exemple;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration // The spring boot will scan all the beans in the configuration class
public class ApplicationConfig {

    @Bean  // Transform Class to Bean
    public MyFirstClass myFirstBean(){
        return new  MyFirstClass("First Bean");
    }

    @Bean  // Transform Class to Bean
    public MyFirstClass mySecondBean(){
        return new  MyFirstClass("Second Bean");
    }

    @Bean  // Transform Class to Bean
    @Primary
    public MyFirstClass myThirdBean(){
        return new  MyFirstClass("Third Bean");
    }

}
