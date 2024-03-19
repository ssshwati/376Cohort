package com.wileyedge;

import org.springframework.context.ApplicationListener;

public class TechDepartment implements ApplicationListener<EmployeeRecruitEvent> {

	@Override
	public void onApplicationEvent(EmployeeRecruitEvent event) {
		System.out.println("tech dept has started processing");
	}

}
