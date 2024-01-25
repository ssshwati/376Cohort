package dataStructureBasic;

import java.util.Scanner;

class NodeCircular<T> {
	T data;
	NodeCircular<T> next;
	NodeCircular<T> prev;

	public NodeCircular(T data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}

public class MyCircularDoublyLinkedList<T> {
	private NodeCircular<T> head;
	private NodeCircular<T> tail;
	private int size = 0;

	public MyCircularDoublyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	public int getSize() {
		return size;
	}

	public NodeCircular<T> getHead() {
		return head;
	}

	public NodeCircular<T> getTail() {
		return tail;
	}

	public void prepend(T data) {
		NodeCircular<T> newNode = new NodeCircular<>(data);
		if (head == null) {
			newNode.next = newNode;
			newNode.prev = newNode;
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			newNode.prev = tail;
			head.prev = newNode;
			tail.next = newNode;
			head = newNode;
		}
		size++;
	}

	public void append(T data) {
		NodeCircular<T> newNode = new NodeCircular<>(data);
		if (head == null) {
			newNode.next = newNode;
			newNode.prev = newNode;
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			newNode.prev = tail;
			tail.next = newNode;
			head.prev = newNode;
			tail = newNode;
		}
		size++;
	}

	public void insertAtIndex(int index, T data) {
		if (index < 0 || index > size) {
			System.out.println("Invalid index. Insertion failed.");
			return;
		}

		NodeCircular<T> newNode = new NodeCircular<>(data);

		if (index == 0) {
			prepend(data);
		} else if (index == size) {
			append(data);
		} else {
			NodeCircular<T> current = head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}

			newNode.next = current;
			newNode.prev = current.prev;
			current.prev.next = newNode;
			current.prev = newNode;
			size++;
		}
	}

	public void deleteAtIndex(int index) {
		if (index < 0 || index >= size) {
			System.out.println("Invalid index. Deletion failed.");
			return;
		}

		if (size == 1) {
			head = null;
			tail = null;
		} else {
			NodeCircular<T> current = head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}

			current.prev.next = current.next;
			current.next.prev = current.prev;

			if (index == 0) {
				head = current.next;
			} else if (index == size - 1) {
				tail = current.prev;
			}
		}

		size--;
	}

	public void display() {
		if (head == null) {
			System.out.println("Empty list");
			return;
		}
		
		NodeCircular<T> current = head;
		do {
			System.out.print(current.data + " ");
			current = current.next;
		} while (current != head);

		System.out.println();
	}

	public static void main(String[] args) {
		MyCircularDoublyLinkedList<Integer> myLinkedList = new MyCircularDoublyLinkedList<>();
		Scanner scanner = new Scanner(System.in);
		int choice;
		do {
			System.out.println(
					"Enter your choice : \n 1.append \n 2.insert \n 3.prepend \n 4.delete \n 5.display \n 6.exit");
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
				System.out.println("head node data : "+myLinkedList.getHead().data);
				System.out.println("tail node data : "+myLinkedList.getTail().data);
				break;
			case 6:
				System.out.println(" BYE ! ");
				break;
			default:
				System.out.println("Invalid choice. please enter any choice between 1 to 5 ");
				break;
			}
		} while (choice != 6);
	}
}
