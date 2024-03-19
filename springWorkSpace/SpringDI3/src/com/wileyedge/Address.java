package com.wileyedge;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "a3") //replacement of the entry <bean id="a3" class = "com.wileyEdge.Address">
public class Address {
//	@Value("140301")
	private int postal;
//	@Value("Kharar")
	private String city;
//	@Value("Punjab")
	private String state;
	
	public Address() {
		System.out.println("Inside default constructor of Address");
	}

	public Address(int postal,String city, String state) {
		System.out.println("Inside parameterized constructor of Address");
		this.postal = postal;
		this.city = city;
		this.state= state;
	}
	
	public int getPostal() {
		return postal;
	}

	public void setPostal(int postal) {
		this.postal = postal;
		System.out.println(" inside setPostal of Address ");
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
		System.out.println(" inside setcity of Address ");
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
		System.out.println(" inside setState of Address ");
	}

	@Override
	public String toString() {
		return "Address [postal=" + postal + ", city=" + city + ", state=" + state + "]";
	}
	
	
}
