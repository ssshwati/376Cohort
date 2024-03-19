package com.wileyedge;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("event.xml");
		HRDepartment hrd = context.getBean("hr", HRDepartment.class);
		hrd.recruitEmployee();

	}
}
