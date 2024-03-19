package com.wileyedge;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("report.xml");
		ReportService service = context.getBean("rs",ReportService.class);
		service.generateReport();
		ConfigurableApplicationContext config = (ConfigurableApplicationContext)context;
		config.close();
	}

}
