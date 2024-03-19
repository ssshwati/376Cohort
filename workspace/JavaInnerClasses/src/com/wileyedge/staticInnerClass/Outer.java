package com.wileyedge.staticInnerClass;

public class Outer {
	static class Inner{
		public void innermethod() {
			System.out.println("hii from inner");
		}
	}
	
	public static void main(String[] args) {
		Outer.Inner in = new Inner();
		in.innermethod();
	}

}
