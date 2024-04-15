package com.fouad.exemple;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Component //Declare the class as Bean automaticaly
//@Service  // Declare the class as Bean automaticaly : @Service extend from component
@Repository //Declare the class as Bean automaticaly
public class MyFirstClass {
    public String sayHello(){
        return "Hello Fom first class";
    }
}
