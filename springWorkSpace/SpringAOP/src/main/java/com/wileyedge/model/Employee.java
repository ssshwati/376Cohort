package com.wileyedge.model;

public class Employee {
	private int eid;
	private String fname;
	private String lname;
	
	public Employee() {
		System.out.println("inside default constructor of Employee.");
	}

	public Employee(int eid, String fname, String lname) {
		super();
		this.eid = eid;
		this.fname = fname;
		this.lname = lname;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Override
	public String toString() {
		return "Employee [id=" + eid + ", fname=" + fname + ", lname=" + lname + "]";
	}
}
