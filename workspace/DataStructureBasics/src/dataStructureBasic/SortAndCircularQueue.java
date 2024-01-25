package dataStructureBasic;

import java.util.Arrays;

class CircularQueue {
	private int size;
	private int front, rear;
	private int[] elements;

	public CircularQueue(int size) {
		this.size = size;
		this.elements = new int[size];
		this.front = -1;
		this.rear = -1;
	}

	public boolean isOverFlow() {
		return (front == 0 && rear == size - 1);
	}

	public boolean isEmpty() {
		return front == -1;
	}

	public void enqueue(int item) {
		if (isOverFlow()) {
			System.out.println("Queue is full. Dequeue elements to avoid overflow.");
			dequeue();
			enqueue(item);
		} else {
			if (front == -1) {
				front = 0;
			}
			rear = (rear + 1) % size;
			elements[rear] = item;
			System.out.println("Enqueued: " + item);
		}
	}

	public int dequeue() {
		int item = -1;
		if (isEmpty()) {
			System.out.println("Queue is empty.");
		} else {
			item = elements[front];
			if (front == rear) {
				front = rear = -1;
			} else {
				front = (front + 1) % size;
			}
			System.out.println("Dequeued: " + item);
		}
		return item;
	}
}

public class SortAndCircularQueue {

	public static void selectionSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
			System.out.println("step " + (i + 1) + " " + Arrays.toString(arr));
			if(i==2) {
				return;
			}
		}
	}

	public static void bubbleSort(int[] arr) {
		int n = arr.length;

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			System.out.println("step " + (i + 1) + " " + Arrays.toString(arr));
			if(i==2) {
				return;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 66, 44, 99, 11, 33 };
		System.out.println("Original Array: " + Arrays.toString(arr));

		selectionSort(arr);
		//bubbleSort(arr);
		System.out.println("Sorted Array: " + Arrays.toString(arr));

		// Enqueue elements into a circular queue
		CircularQueue circularQueue = new CircularQueue(4);
		for (int element : arr) {
			circularQueue.enqueue(element);
		}

		// Dequeue elements to avoid overflow
//		while (!circularQueue.isEmpty()) {
//			int dequeuedElement = circularQueue.dequeue();
//		}
	}
}
