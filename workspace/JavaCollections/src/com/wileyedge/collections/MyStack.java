package com.wileyedge.collections;

public class MyStack<E> {
	private int x;
	private E[] data = (E[]) new Object[10];

	public void push(E obj) {
		data[x] = obj;
		x++;
	}

	public E pop() {
		return data[--x];
	}

	public static void main(String[] args) {
		MyStack<String> ms = new MyStack<>();
		ms.push("Shwati");
		ms.push("Shweta");
		System.out.println(ms.pop());
		System.out.println(ms.pop());

		MyStack<Integer> ms1 = new MyStack();
		ms1.push(100);
		ms1.push(200);
		System.out.println(ms1.pop());
		System.out.println(ms1.pop());
	}
}
