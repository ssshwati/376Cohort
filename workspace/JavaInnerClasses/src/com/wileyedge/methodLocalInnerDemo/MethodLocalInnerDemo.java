package com.wileyedge.methodLocalInnerDemo;

public class MethodLocalInnerDemo {

	private int x = 10;
	
	public void outermethod() {
		int y = 9;
		class localInner{
			int z = 11;
			public void innermethod() {
				System.out.println("from method local class, I can access outer's private x "+ x);
				System.out.println("from method local class, I can access outer method's y "+ y);
				System.out.println("from method local class, I can access inner's private z "+ z);
			}//end of inner method
		}//end of inner class
		localInner inner = new localInner();
		inner.innermethod();
	}//end of outer method
	public static void main(String[] args) {
		MethodLocalInnerDemo demo = new MethodLocalInnerDemo();
		demo.outermethod();
	}

}
