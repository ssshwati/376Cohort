package com.wileyedge.reflectionDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Person {
	public String fname;
	public String lname;

	public Person() {
		
	}
	public Person(String fname, String lname) {
		this.fname = fname;
		this.lname = lname;
	}

	public String getDescription() {
		return "Person info";
	}

}

public class ReflectionDemo {
	public static void main(String[] args) {
		Person p = new Person("Shwati", "Kumari");
		Class class1 = p.getClass();
		System.out.println("========constructors name==============");
		Constructor[] constructorArray = class1.getConstructors();
		for(Constructor c:constructorArray) {
			System.out.println(c);
		}
		System.out.println("========methods name==============");
		Method[] methods = class1.getMethods();
		for(Method m:methods) {
			System.out.println(m.getName());
		}
		System.out.println("========fields name==============");
		Field[] fields = class1.getFields();
		for(Field f:fields) {
			System.out.println(f);
		}
	}

}
