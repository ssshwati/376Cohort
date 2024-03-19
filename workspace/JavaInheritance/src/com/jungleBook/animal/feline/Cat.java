package com.jungleBook.animal.feline;

import com.jungleBook.animal.Animal;
import com.jungleBook.animal.Pet;

public class Cat extends Animal implements Pet{
	public Cat(String name, String color) {
		super(name, color);
		System.out.println("inside Cat class parameterized constructor");
	}

	@Override
	public void makeNoise() {
		System.out.println(this.name + " is mewing");
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println(this.name + " is running");
	}

	@Override
	public void beFriendly() {
		// TODO Auto-generated method stub
		System.out.println(this.name + " is dancing");
	}

}
