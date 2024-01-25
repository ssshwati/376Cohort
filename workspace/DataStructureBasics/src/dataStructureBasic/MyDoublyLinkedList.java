package dataStructureBasic;

import java.util.Scanner;

class NodeDouble<T> {
	T data;
	NodeDouble<T> next;
	NodeDouble<T> prev;

	public NodeDouble(T data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}

public class MyDoublyLinkedList<T> {
	private NodeDouble<T> head;
	private NodeDouble<T> tail;
	private int size = 0;

	public MyDoublyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	public int getSize() {
		return size;
	}

	public NodeDouble<T> getHead() {
		return head;
	}

	public NodeDouble<T> getTail() {
		return tail;
	}

	public void prepend(T data) {
		NodeDouble<T> newNode = new NodeDouble<>(data);
		newNode.next = head;
		newNode.prev = null;
		if (head != null) {
			head.prev = newNode;
		}
		head = newNode;
		if (tail == null) {
			tail = newNode;
		}
		size++;
	}

	public void append(T data) {
		NodeDouble<T> newNode = new NodeDouble<>(data);
		newNode.next = null;
		newNode.prev = tail;
		if (tail != null) {
			tail.next = newNode;
		}
		tail = newNode;
		if (head == null) {
			head = newNode;
		}
		size++;
	}

	public void insertAtIndex(int index, T data) {
		if (index < 0 || index > size) {
			System.out.println("Invalid index. Insertion failed.");
			return;
		}

		NodeDouble<T> newNode = new NodeDouble<>(data);

		if (index == 0) {
			prepend(data);
		} else if (index == size) {
			append(data);
		} else {
			NodeDouble<T> current;
			if (index <= size / 2) {
				// If the index is closer to the front, start from the head
				current = head;
				for (int i = 0; i < index; i++) {
					current = current.next;
				}
			} else {
				// If the index is closer to the end, start from the tail
				current = tail;
				for (int i = size - 1; i > index; i--) {
					current = current.prev;
				}
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
		if (index == 0) {
			head = head.next;
			if (head != null) {
				head.prev = null;
			}
		} else if (index == size - 1) {
			tail = tail.prev;
			if (tail != null) {
				tail.next = null;
			}
		} else {
			NodeDouble<T> current;
			if (index <= size / 2) {
				// If the index is closer to the front, start from the head
				current = head;
				for (int i = 0; i < index; i++) {
					current = current.next;
				}
			} else {
				// If the index is closer to the end, start from the tail
				current = tail;
				for (int i = size - 1; i > index; i--) {
					current = current.prev;
				}
			}
			current.prev.next = current.next;
			current.next.prev = current.prev;
		}
		size--;
	}

	public void display() {
		NodeDouble<T> current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		MyDoublyLinkedList<Integer> myLinkedList = new MyDoublyLinkedList<>();
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
