package leetcode.medium;

import java.util.Arrays;

public class FindTheSmallestDivisorGivenThreshold {

	public static void main(String[] args) {
		smallestDivisor(new int[]{1, 2, 5, 9}, 6);
	}

	public static int smallestDivisor(int[] nums, int threshold) {
		Arrays.sort(nums);

		int left = 1, right = nums[nums.length - 1];
		int mid, currentSum;

		while (left < right) {
			mid = (right + left) / 2;
			currentSum = 0;
			for(int i=0; i< nums.length; i++) {
				currentSum+= (int) Math.ceil(1.0 * nums[i]/ mid);
			}

			if(currentSum > threshold) {
				left = mid + 1;
			} else{
				right = mid;
			}
		}
		return left;
	}
}
