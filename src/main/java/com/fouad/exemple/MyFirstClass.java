package com.fouad.exemple;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Component //Declare the class as Bean automaticaly
//@Service
public class MyFirstClass {
    private  String myVar;

    public MyFirstClass (String myVar){
        this.myVar = myVar;
    }

    public String sayHello(){
        return "Hello Fom first class ==> myVar = "+myVar;
    }
}
