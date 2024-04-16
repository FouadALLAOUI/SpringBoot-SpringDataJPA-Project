package com.fouad.exemple;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration // The spring boot will scan all the beans in the configuration class
@Profile("dev") // All this configuration could be available just for dev environment
public class ApplicationConfig {

    @Bean("bean1")  // Transform Class to Bean
    //@Profile("dev")  // Make this bean specific for the dev environment
    public MyFirstClass myFirstBean(){
        return new  MyFirstClass("First Bean");
    }

    @Bean  // Transform Class to Bean
    //@Profile("test")
    public MyFirstClass mySecondBean(){
        return new  MyFirstClass("Second Bean");
    }

    @Bean  // Transform Class to Bean
    //@Primary //Priority of Beans
    public MyFirstClass myThirdBean(){
        return new  MyFirstClass("Third Bean");
    }

}
