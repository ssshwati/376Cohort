package com.wileyEdge;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Address implements Serializable{
	private String country;
	private String city;
	public Address() {
		System.out.println("default Address constructor");
	}
	public Address(String country, String city) {
		super();
		System.out.println("parameterized Address constructor");
		this.country = country;
		this.city = city;
	}
	@Override
	public String toString() {
		return "\ncountry=" + country + "\ncity=" + city;
	}
}

class Student implements Serializable{
	private int rollno;
	private String name;
	private transient Address addr;
	public Student() {
		System.out.println("default student constructor");
	}
	public Student(int roll, String name) //tag interface or marker interface
	{
		System.out.println("parameterized student constructor");
		this.rollno = roll;
		this.name = name;
	}
	
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "name : "+ this.name + "\nroll : "+this.rollno + "\nAddress : " + this.addr;
	}
}
public class SerialisationDemo {
	public static void main(String[] args) {
		Student s1 = new Student(33,"Shwati");
		Address a1 = new Address("India","Purnea");
		s1.setAddr(a1);
		File file = new File("C:\\C376\\student.ser");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			oos.writeObject(s1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("serialisation done");
		}
	}
}
