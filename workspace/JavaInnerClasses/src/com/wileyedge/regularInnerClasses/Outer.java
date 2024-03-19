package com.wileyedge.regularInnerClasses;

public class Outer {
	private int x = 10;

	public class Inner {
		public void method1() {
			System.out.println("I can access private var x of outer class in inner class");
		}
	}

	public static void main(String[] args) {
		Outer outer = new Outer();
		Inner inner = outer.new Inner();
		inner.method1();
	}

}
