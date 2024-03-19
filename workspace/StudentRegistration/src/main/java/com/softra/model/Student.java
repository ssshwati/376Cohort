package com.softra.model;

public class Student {
    // Variables
    private String name;
    private int age;
    private long mobile;
    private String email;
    private String address;
    
    // Constructor
    public Student() {
        // Default constructor
    }

    
    public Student(String name, int age, long mobile, String email, String address) {
		super();
		this.name = name;
		this.age = age;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
	}


	// Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", mobile=" + mobile + ", email=" + email + ", address="
				+ address + "]";
	}
    
    
}
