package com.fouad.exemple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootSpringDataJpaApplication {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(SpringBootSpringDataJpaApplication.class, args);

		MyFirstService myFirstService = ctx.getBean(MyFirstService.class); //get the bean
		System.out.println(myFirstService.tellStory());
		System.out.println(myFirstService.getCustomProperty());
		System.out.println(myFirstService.getCustomPropertyInt());
		System.out.println(myFirstService.getCustomPropertyFromAnotherFile());
		System.out.println(myFirstService.getCustomPropertyFromAnotherFile2());


	}




}
