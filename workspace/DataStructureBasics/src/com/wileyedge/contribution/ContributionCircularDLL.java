package com.wileyedge.contribution;

import java.util.Scanner;

class Node<T> {
    T data;
    Node<T> next;
    Node<T> prev;

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class CircularDoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    public CircularDoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            head.next = head;
            head.prev = head;
        } else {
            Node<T> last = tail;
            newNode.next = head;
            newNode.prev = last;
            last.next = newNode;
            head.prev = newNode;
            tail = newNode;
        }
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }
}

public class ContributionCircularDLL {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter total no of last year contributions : ");
        int n = scanner.nextInt();
        CircularDoublyLinkedList<Integer> lastYearContributions = new CircularDoublyLinkedList<>();

        System.out.println("Enter " + n + " values of last year contributions : ");
        for (int i = 0; i < n; i++) {
            lastYearContributions.add(scanner.nextInt());
        }

        // Calculate new contributions
        CircularDoublyLinkedList<Integer> newContributions = calculateContributions(lastYearContributions);

        System.out.println("Values of current year contributions : ");
        printList(newContributions);
    }

    public static CircularDoublyLinkedList<Integer> calculateContributions(CircularDoublyLinkedList<Integer> lastYearContributions) {
        CircularDoublyLinkedList<Integer> newContributions = new CircularDoublyLinkedList<>();
        Node<Integer> current = lastYearContributions.getHead();

        do {
            // Calculate the sum of contributions of the two neighbors to the left
            int leftNeighbor1 = current.next.data;
            int leftNeighbor2 = current.next.next.data;

            // Calculate the new contribution for the current apartment
            int newContribution = leftNeighbor1 + leftNeighbor2;
            newContributions.add(newContribution);

            current = current.next;
        } while (current != lastYearContributions.getHead());

        return newContributions;
    }

    public static void printList(CircularDoublyLinkedList<Integer> list) {
        Node<Integer> current = list.getHead();

        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != list.getHead());

        System.out.println();
    }
}
