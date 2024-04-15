package com.fouad.exemple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {


    private  MyFirstClass myFirstClass;

    @Autowired // use this method as setter to use to inject the necessary bean
    public void injectDependencies(@Qualifier("mySecondBean") MyFirstClass myFirstClass){
        this.myFirstClass = myFirstClass;
    }

    public String tellStory(){
        return "the dependency is saying : " +myFirstClass.sayHello();
    }
}
