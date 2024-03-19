package com.jungleBook.animal;

public abstract class Animal {
	public String name;
	public String color;

	public Animal() {  //can't be instantiated
		System.out.println("inside Animal class constructor");
	}

	public Animal(String name, String color) {
		System.out.println("inside Animal class parameterized constructor");
		this.name = name;
		this.color = color;
	}

	public abstract void makeNoise();
	//this method must be overridden in child class

	public void sleep() {
		System.out.println(this.name + " is sleeping");
	}


}
