package com.wileyedge.practice;

import java.util.*;

public class TripletSUm {
	public static List<List<Integer>> findTriplets(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum == target) {
					result.add(Arrays.asList(nums[i], nums[left], nums[right]));
					left++;
					right--;
				} else if (sum < target) {
					left++;
				} else if (sum > target) {
					right--;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 0, -3, -1, 2, 1 };
		int target = -2;
		List<List<Integer>> triplets = findTriplets(nums, target);

		if (triplets.isEmpty()) {
			System.out.println("No triplets found that sum up to the target.");
		} else {
			System.out.println("Triplets that sum up to " + target + ":");
			for (List<Integer> triplet : triplets) {
				System.out.println(triplet);
			}
		}
	}
}
