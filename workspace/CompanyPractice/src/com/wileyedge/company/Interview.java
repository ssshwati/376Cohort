package com.wileyedge.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Interview {
	public static void main(String[] args) {
		Interview solution = new Interview();
		int[] candidates = { 2, 3, 6, 7 ,1,8};
		int target = 8;
//		int arr[] = { 1, 3, 4, 2, 5 };
//		int sum = 5;
//		int result = 0;
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = i + 1; j < arr.length; j++) {
//				if (arr[i] + arr[j] == sum) {
//					result++;
//				}
//			}
//		}
//		System.out.println(result);

		Map<Integer, Integer> ump = new HashMap<>();
		int count = 0;
		for (int it : candidates) {
			int res = target - it;
			if (!ump.containsKey(res)) {
				ump.put(it, 1);
			} else {
				count++;
			}
		}

		System.out.println("count: " + count);
	}

}
