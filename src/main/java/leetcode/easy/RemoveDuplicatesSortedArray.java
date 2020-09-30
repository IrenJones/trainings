package leetcode.easy;

import java.util.Arrays;

public class RemoveDuplicatesSortedArray {

	public static void main(String[] args) {

		int[] nums = new int[]{1, 1, 2, 2};

		// nums is passed in by reference. (i.e., without making a copy)
		int len = removeDuplicates(nums);

		// any modification to nums in your function would be known by the caller.
		// using the length returned by your function, it prints the first len elements.
		for (int i = 0; i < len; i++) {
			System.out.println(nums[i]);
		}
	}

	public static int removeDuplicates(int[] nums) {
		int currentIterator = 0;
		int size = nums.length;

		for(int i=0; i< size; i++){
			if(nums[currentIterator] != nums[i]){
				currentIterator++;
				nums[currentIterator] = nums[i];
			}
		}

		return currentIterator + 1;
	}
}
