package com.fouad.exemple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {
    @Autowired //Field Injection
    @Qualifier("bean1")
    private  MyFirstClass myFirstClass;

/*    public MyFirstService(MyFirstClass myFirstClass) { //Constructor injection
        this.myFirstClass = myFirstClass;
    }*/

    public String tellStory(){
        return "the dependency is saying : " +myFirstClass.sayHello();
    }
}
