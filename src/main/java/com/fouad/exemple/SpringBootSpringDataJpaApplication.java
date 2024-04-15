package com.fouad.exemple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootSpringDataJpaApplication {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(SpringBootSpringDataJpaApplication.class, args);

		MyFirstClass myFirstClass = ctx.getBean("myBean",MyFirstClass.class); //get the bean
		System.out.println(myFirstClass.sayHello());


	}




}
