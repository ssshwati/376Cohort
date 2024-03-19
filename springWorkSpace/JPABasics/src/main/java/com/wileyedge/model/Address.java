package com.wileyedge.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

//@Embeddable
public class Address {
	
	@Column(name="city", nullable=false)
	private String city;
	@Column(name="zip", nullable=false)
	private int zip;
	
	public Address() {
		
	}

	public Address(String city, int zip) {
		super();
		this.city = city;
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", zip=" + zip + "]";
	}
	
}
