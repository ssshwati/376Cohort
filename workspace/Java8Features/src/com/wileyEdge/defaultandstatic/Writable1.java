package com.wileyEdge.defaultandstatic;

@FunctionalInterface
public interface Writable1 {
	void abc();
	default void write1() {
		System.out.println("inside default write1 method of Writable1 interface");
	}
	default void write2() {
		System.out.println("inside default write2 method of Writable1 interface");
	}
	static void pqr() {
		System.out.println("inside static pqr method of Writable1 interface");
	}
	//only in java version greater than 8, we can give body to methods in interface 
}
