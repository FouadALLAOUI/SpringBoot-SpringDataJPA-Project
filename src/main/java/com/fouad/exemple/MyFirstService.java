package com.fouad.exemple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    private final MyFirstClass myFirstClass;
    @Autowired // Use the needed Beans
    public MyFirstService(MyFirstClass myFirstClass) { //Constructor injection
        this.myFirstClass = myFirstClass;
    }
    public String tellStory(){
        return "the dependency is saying : " +myFirstClass.sayHello();
    }
}
