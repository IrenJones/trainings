package leetcode.easy;

public class BinarySearch {

	public static void main(String[] args) {
		System.out.println(search(new int[]{-1,0,3,5,9,12}, 1) == -1);
	}

	public static int search(int[] nums, int target) {
		int i;
		int left = 0;
		int right = nums.length - 1;
		while(left <= right) {
			i = left + (right - left)/2;
			if (nums[i] == target) {
				return i;
			} else if (nums[i] > target) {
				right = i - 1;
			} else {
				left = i + 1;
			}
		}

		return -1;
	}
}
