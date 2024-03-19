package com.wileyedge.practice;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackImpl<T> {
    private Node<T> top; // Top of the stack

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = top; 
        top = newNode; 
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T data = top.data; 
        top = top.next; 
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data; 
    }

    public boolean isEmpty() {
        return top == null;
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
