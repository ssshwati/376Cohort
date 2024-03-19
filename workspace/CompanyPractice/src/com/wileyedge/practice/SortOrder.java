package com.wileyedge.practice;

public class SortOrder {

	static int[] rotateSubArray(int[] arr, int l, int r)
	{
		int temp = arr[r];
		for (int j = r; j > 0; j--) {
			arr[j] = arr[j - 1];
		}
		arr[l] = temp;
		return arr;
	}

	static int[] moveNegative(int[] arr)
	{
		int j = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				j += 1;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				// Done to manage order too
				if (i - j >= 2)
					rotateSubArray(arr, j + 1, i);
			}
		}
		return arr;
	}

	// Driver Code
	public static void main(String args[])
	{
		int[] arr = { -1,-2,-3,5,-116,7,9};
		arr = moveNegative(arr);

		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
}
