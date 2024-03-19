package com.wileyEdge.defaultandstatic;

public interface Writable2 {
	default void write1() {
		System.out.println("inside default write1 method of Writable2 interface");
	}

	static void pqr() {
		System.out.println("inside static pqr method of Writable2 interface");
	}
}
