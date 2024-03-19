package com.jungleBook.animal.feline;

import com.jungleBook.animal.Animal;

public class Tiger extends Animal {
	
	public Tiger(String name, String color)
	{
		super(name,color);
	}

	@Override
	public void makeNoise() {
		// TODO Auto-generated method stub
		System.out.println(this.name + " is roaring");
	}

}
