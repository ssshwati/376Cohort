package com.emp;

import com.emp.utility.Address;

public class Employee {

	public int id;
	public String fName;
	public String lName;
	private Address addr; // addr is of type Address and instance variable of Employee class

	public Employee() {
		System.out.println("object of Employee is being created");
	}
	
	public Employee(int id ,String fName,String lName)
	{
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		System.out.println("object of Employee is being created using parameterized constructor");
	}
	
	public Employee(int id ,String fName,String lName, Address addr)
	{
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.addr = addr;
		System.out.println("object of Employee is being created using new parameterized constructor");
	}
	
	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setfName(String fName) {
		this.fName = fName;

	}

	public String getfName() {
		return fName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getlName() {
		return lName;
	}
	
	@Override    //annotation
	public String toString() {
		// TODO Auto-generated method stub
		return this.id+ " " + this.fName +" " + this.lName + " " + this.addr;
	}


}
