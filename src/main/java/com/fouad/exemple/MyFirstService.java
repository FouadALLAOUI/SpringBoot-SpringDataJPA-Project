package com.fouad.exemple;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:custom.properties")
public class MyFirstService {

    private  MyFirstClass myFirstClass;
    @Value("Welcome -- ")
    private String customProperty;
    @Value("${my.prop}") // Injection of values
    private String customPropertyFromAnotherFile;
    @Value("12345")
    private Integer customPropertyInt;

    public MyFirstService(@Qualifier("bean1") MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    public String tellStory(){
        return "the dependency is saying : " +myFirstClass.sayHello();
    }


    public String getCustomPropertyFromAnotherFile() {
        return customPropertyFromAnotherFile;
    }

    public String getCustomProperty() {
        return customProperty;
    }

    public Integer getCustomPropertyInt() {
        return customPropertyInt;
    }
}
