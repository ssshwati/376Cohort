package com.wileyedge.practice;

import java.util.Stack;

public class StackImp<T> {

	private Node<T> top;
	
	private class Node<T>{
		private T data;
		private Node next;
		public Node (T data) {
			this.data = data;
		}
	}
	
	public void push(T data) {
		Node<T> newNode = new Node<>(data);
		newNode.next=top;
		top=newNode;
	}
	
	public T pop() {
		if(isEmpty()) {
			return null;
		}
		T data =  top.data;
		top=top.next;
		return data;
	}
	
	public T peek() {
		if(!isEmpty()) {
			return top.data;
		}
		return null;
	}
	
	public boolean isEmpty() {
		return top==null;
	}
	
	public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Peek: " + stack.peek()); // Should print 30
        System.out.println("Pop: " + stack.pop());   // Should print 30
        System.out.println("Peek: " + stack.peek()); // Should print 20
        System.out.println("Pop: " + stack.pop());   // Should print 20
    }
	
	
	
}
