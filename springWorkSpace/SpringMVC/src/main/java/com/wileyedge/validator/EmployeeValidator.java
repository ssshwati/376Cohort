package com.wileyedge.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.wileyedge.model.Employee;

@Component(value="empval")
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Employee.class.equals(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("inside validate method");
		Employee emp = (Employee) target;
		ValidationUtils.rejectIfEmpty(errors, "fname", "fname.error");
		
	}

}
