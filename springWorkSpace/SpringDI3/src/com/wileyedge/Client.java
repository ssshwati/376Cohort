package com.wileyedge;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
//		ApplicationContext context= new ClassPathXmlApplicationContext("emp.xml");
		ApplicationContext context= new AnnotationConfigApplicationContext(MyConfig.class);
		
//		Employee emp1 = context.getBean("e1",Employee.class);
//		Employee emp2 = context.getBean("e1",Employee.class);
//		System.out.println(emp1);
//		System.out.println(emp2);
//		if(emp1==emp2) {
//			System.out.println("both are pointing to same object");
//		}else {
//			System.out.println("both are different object");
//		}
		
//		Address add1 = context.getBean("ad1",Address.class);
//		System.out.println(add1);
//		System.out.println(emp1);
		
//		Employee emp3 = context.getBean("e2",Employee.class);
		Employee emp3 = context.getBean("e3",Employee.class);
		System.out.println(emp3);
		
		ConfigurableApplicationContext configCon = (ConfigurableApplicationContext) context;
		configCon.close();
	}
}