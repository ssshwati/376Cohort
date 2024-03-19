package com.wileyedge.practice;

public class isSorted {
	public static boolean isSortedAscending(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if ((arr[i - 1] ^ arr[i]) < 0)
                return false;
        }
        return true;
    }

    public static boolean isSortedDescending(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
        	 if ((arr[i - 1] ^ arr[i]) <= 0)
                 return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        int[] ascendingArray = {1, 2, 3, 4, 5};
        int[] descendingArray = {5, 4, 3, 2, 1};
        int[] unsortedArray = {1, 3, 2, 5, 4};

        System.out.println("Is ascending array sorted? " + isSortedAscending(ascendingArray));
        System.out.println("Is descending array sorted? " + isSortedDescending(descendingArray));
        System.out.println("Is unsorted array sorted? " + isSortedAscending(unsortedArray));
    }
}
