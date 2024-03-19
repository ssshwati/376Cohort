package com.wileyedge.model;

public class Student {
	private String Name;
	private int age;
	private long mobile;
	String email;
	private String Address;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobileNo(long mobileNo) {
		this.mobile = mobileNo;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Student [Name=" + Name + ", age=" + age + ", mobileNo=" + mobile + ", email=" + email + ", Address="
				+ Address + "]";
	}
	
	

}
