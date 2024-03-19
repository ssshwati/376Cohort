package com.wileyedge.model;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee implements Serializable {

	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String fname;
	@Column
	private String lname;
	@Embedded
	@AttributeOverrides(
			{ @AttributeOverride(name = "city", column = @Column(name = "emp_city")),
			@AttributeOverride(name = "zip", column = @Column(name = "emp_zip")) 
			})
	private Address addr;

	public Employee() {
		System.out.println("inside Employee default constructor");
	}

	public Employee(int id, String fname, String lname) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fname=" + fname + ", lname=" + lname + "]";
	}

}
