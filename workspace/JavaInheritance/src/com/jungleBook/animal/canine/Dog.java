package com.jungleBook.animal.canine;

import com.jungleBook.animal.Animal;
import com.jungleBook.animal.Pet;

public class Dog extends Animal implements Pet{

	public Dog() {
		System.out.println("inside Dog class constructor");
		this.name = name;
		this.color = color;
	}

	public Dog(String name, String color) {
		super(name, color);
		System.out.println("inside Dog class parameterized constructor");
	}

	@Override
	public void makeNoise() {
		System.out.println(this.name + " is barking");
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println(this.name + " is jumping");
	}

	@Override
	public void beFriendly() {
		// TODO Auto-generated method stub
		System.out.println(this.name + " is waving his tail");
	}

}
