package com.wileyedge.firstbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication 		//@SpringBootApplication = @Configuration + @ComponentScan + @EnableAutoConfiguration
public class FirstbootdemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(FirstbootdemoApplication.class, args);
		Employee emp = context.getBean("e1",Employee.class);
		System.out.println(emp);
	}

}
