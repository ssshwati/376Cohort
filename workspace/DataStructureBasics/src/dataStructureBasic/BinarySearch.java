package dataStructureBasic;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
	private static int binarySearch(int[] array, int key, int low, int high) {
		if (low <= high) {
			int mid = low + (high - low) / 2;
			if (array[mid] == key) {
				return mid; // Key found
			} else if (array[mid] < key) {
				return binarySearch(array, key, mid + 1, high); // Search in the right half
			} else {
				return binarySearch(array, key, low, mid - 1); // Search in the left half
			}
		}
		return -1; // Key not found
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the size of the array: ");
		int size = scanner.nextInt();
		int[] array = new int[size];
		System.out.println("Enter the elements of the array:");
		for (int i = 0; i < size; i++) {
			array[i] = scanner.nextInt();
		}
		Arrays.sort(array);

		System.out.print("Sorted array: ");
		for (int num : array) {
			System.out.print(num + " ");
		}
		System.out.println();
		System.out.print("Enter the element to search: ");
		int key = scanner.nextInt();
		int result = binarySearch(array, key, 0, array.length - 1);
		if (result == -1) {
			System.out.println("Element not found in the array.");
		} else {
			System.out.println("Element found at index " + result);
		}
	}
}
