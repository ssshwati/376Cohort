package com.wileyedge;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class HRDepartment implements ApplicationContextAware{

	private ApplicationContext context ;
	public void recruitEmployee() {
		System.out.println("new employee is recruited");
		this.context.publishEvent(new EmployeeRecruitEvent(this));
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		System.out.println("inside setApplicationContext of HRD");
		this.context = context;
	}
	
}
