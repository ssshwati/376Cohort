package dataStructureBasic;

import java.util.Scanner;

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public MyLinkedList() {
        this.head = null;
    }

    public int getSize() {
        return size;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void prepend(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        size++;
    }

    public void append(T data) {
        if (head == null) {
            prepend(data);
            return;
        }
        Node<T> newNode = new Node<>(data);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void insertAtIndex(int index, T data) {
        if (index < 0 || index > size) {
            System.out.println("Invalid index. Insertion failed.");
            return;
        }

        Node<T> newNode = new Node<>(data);
        if (index == 0) {
            prepend(data);
        } else if (index == size) {
            append(data);
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index. Deletion failed.");
            return;
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Enter your choice : \n 1.append \n 2.insert \n 3.prepend \n 4.delete \n 5.display \n 6.exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the data you want to add into the list ");
                    int data = scanner.nextInt();
                    myLinkedList.append(data);
                    System.out.println("list after operation is here ");
                    myLinkedList.display();
                    break;
                case 2:
                    System.out.println("Enter the index at which you want to add new data into the list ");
                    int index = scanner.nextInt();
                    System.out.println("Enter the data you want to add into the list ");
                    int newData = scanner.nextInt();
                    myLinkedList.insertAtIndex(index, newData);
                    System.out.println("list after operation is here ");
                    myLinkedList.display();
                    break;
                case 3:
                    System.out.println("Enter the data you want to prepend into the list ");
                    int prependData = scanner.nextInt();
                    myLinkedList.prepend(prependData);
                    System.out.println("list after operation is here ");
                    myLinkedList.display();
                    break;
                case 4:
                    System.out.println(" Enter the index at which you want to delete from the list ");
                    int deleteIndex = scanner.nextInt();
                    myLinkedList.deleteAtIndex(deleteIndex);
                    System.out.println("list after operation is here ");
                    myLinkedList.display();
                    break;
                case 5:
    				System.out.println("Here is your list of size "+myLinkedList.getSize());
                    myLinkedList.display();
                    break;
                case 6:
//                    System.out.println(myLinkedList.getHead().data);
//                    System.out.println(myLinkedList.getTail().data);
                    System.out.println(" BYE ! ");
                    break;
                default:
                    System.out.println("Invalid choice. please enter any choice between 1 to 5 ");
                    break;
            }
        } while (choice != 6);
    }
}
