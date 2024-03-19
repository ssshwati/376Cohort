package com.wileyedge.anonymousInnerClass;

interface Pet {
	void play();

	void beFriendly();
}

abstract class Animal {
	public abstract void makeNoise();
}

class Dog extends Animal implements Pet {
	@Override
	public void play() {
		System.out.println("Dog is playing");
	}

	@Override
	public void beFriendly() {
		System.out.println("Dog is being friendly");
	}

	@Override
	public void makeNoise() {
		System.out.println("Dog is barking");
	}
}

public class AnonymousInnerClass {

	public static void main(String[] args) {
		Animal a1 = new Dog();
		Pet p1 = new Dog();
		Animal a2 = new Animal() {
			@Override
			public void makeNoise() {
				System.out.println("Cat is mewing");
			}
		};
		Pet p2 = new Pet() {
			@Override
			public void play() {
				System.out.println("Tiger is running");
			}

			@Override
			public void beFriendly() {
				System.out.println("Tiger is being friendly");
			}
		};
		a1.makeNoise();
		p1.beFriendly();
		p1.play();
		a2.makeNoise();
		p2.beFriendly();
		p2.play();
	}

}
