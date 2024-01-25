package dataStructureBasic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SortAndQueue {

	public static void selectionSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			// Swap the found minimum element with the first element
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

		// Enqueue elements into a queue
		Queue<Integer> queue = new LinkedList<>();
		for (int element : arr) {
			enqueue(queue, element);
		}
		
//        for(int i =0;i<3;i++) {
//        	enqueue(queue, arr[i]);
//        }

		// Dequeue elements to avoid overflow
//		while (!queue.isEmpty()) {
//			int dequeuedElement = dequeue(queue);
//			System.out.println("Dequeued: " + dequeuedElement);
//		}
	}

	private static void enqueue(Queue<Integer> queue, int element) {
		if (queue.size() < 4) {
			queue.add(element);
			System.out.println("Enqueued: " + element);
		} else {
			System.out.println("Queue is full. Dequeue elements to avoid overflow.");
			System.out.println("Dequeued: " +dequeue(queue));
			enqueue(queue,element);
		}
	}

	private static int dequeue(Queue<Integer> queue) {
		if (!queue.isEmpty()) {
			return queue.poll();
		} else {
			return -1;
		}
	}
}
