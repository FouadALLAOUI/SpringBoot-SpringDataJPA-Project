package com.fouad.exemple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    private  MyFirstClass myFirstClass;

    private Environment environment;

    @Autowired // use this method as setter to use to inject the necessary bean
    public void injectDependencies(@Qualifier("bean1") MyFirstClass myFirstClass){
        this.myFirstClass = myFirstClass;
    }

    public String tellStory(){
        return "the dependency is saying : " +myFirstClass.sayHello();
    }

    public String getJavaVersion(){
        return environment.getProperty("java.version");
    }

    public String getOsName(){
        return environment.getProperty("os.name");
    }

    @Autowired  // Setter Injection for an environment object
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }



}
