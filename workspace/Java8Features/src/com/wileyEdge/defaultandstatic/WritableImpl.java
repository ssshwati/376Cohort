package com.wileyEdge.defaultandstatic;

import com.wileyEdge.defaultandstatic.Writable1;

public class WritableImpl implements Writable1, Writable2 {
	@Override
	public void abc() {
		System.out.println("overridden abc method of WritableImpl");
	}

	@Override
	public void write1() {
		//Writable2.super.write1();
		System.out.println("overridden write1 method of WritableImpl");
	}
}
