package com.wileyedge.singletable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "p")
public class PermanentEmployee extends Employee {
	private int pfAccountNumber;
	
	public int getPfAccountNumber() {
		return pfAccountNumber;
	}
	
	public PermanentEmployee() {
		super();
	}

	public PermanentEmployee(int id, String fname, String lname) {
		super(id, fname, lname);
		
	}


	public PermanentEmployee(String fname, String lname,int pfAccountNumber) {
		super(fname, lname);
		this.pfAccountNumber=pfAccountNumber;
	}
	

	public void setPfAccountNumber(int pfAccountNumber) {
		this.pfAccountNumber = pfAccountNumber;
	}
	
}
