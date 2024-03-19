package com.jungleBook;

import com.jungleBook.animal.Animal;
import com.jungleBook.animal.Pet;
import com.jungleBook.animal.canine.Dog;
import com.jungleBook.animal.feline.Cat;
import com.jungleBook.animal.feline.Tiger;

public class TestAnimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Animal a=new Animal();
//		Dog a=new Dog();
//		a.name="Rabbit";
//		a.color="White";
//		a.makeNoise();
//		a.sleep();
//		System.out.println("=====================");	
//		Dog d=new Dog("Oreo","Brown");
//		d.makeNoise();
//		d.sleep();
//		System.out.println("=====================");		
//		Cat c = new Cat("Cosy","Brown");
//		c.makeNoise();
//		c.sleep();

//		Animal a1 = new Dog("oreo", "black");
//		a1.makeNoise();
//		a1.sleep();
//		
//		Animal a2 = new Cat("cosy", "brown");
//		a2.makeNoise();
//		a2.sleep();
//
//		Animal a3 = new Tiger("Tigris","Brown");
//		a3.makeNoise();
//		a2.sleep();
		
		Animal[] ani = new Animal[5];
		ani[0] = new Dog("oreo", "black");
		ani[1] = new Cat("cosy", "brown");
		ani[2] = new Dog("DJ","Black");
		ani[3] = new Cat("sweety","Brown");
		ani[4] = new Tiger("Tigris","Brown");
		
		for(Animal a:ani)
		{
			a.makeNoise();
			a.sleep();
			System.out.println("=====================");
		}
		
		Pet[] pArr = new Pet[4];
		pArr[0] = new Dog("oreo", "black");
		pArr[1] = new Cat("cosy", "brown");
		pArr[2] = new Dog("DJ", "black");
		pArr[3] = new Cat("sweety", "brown");
		
		
		for(Pet a:pArr)
		{
			a.play();
			a.beFriendly();
			System.out.println("=====================");
		}
		
		Pet p = new Pet() {

			@Override
			public void play() {
				
			}

			@Override
			public void beFriendly() {
				
			}
			
		};
	}

}