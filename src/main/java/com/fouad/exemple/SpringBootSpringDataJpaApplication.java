package com.fouad.exemple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

@SpringBootApplication
public class SpringBootSpringDataJpaApplication {

	public static void main(String[] args) {

		var app = new  SpringApplication(SpringBootSpringDataJpaApplication.class);
		app.setDefaultProperties(Collections.singletonMap("spring.profiles.active", "dev"));

		var ctx = app.run(args);

		MyFirstService myFirstService = ctx.getBean(MyFirstService.class); //get the bean
		System.out.println(myFirstService.tellStory());
		System.out.println(myFirstService.getCustomProperty());
		System.out.println(myFirstService.getCustomPropertyInt());


	}




}
