package leetcode.leetcode_by_topics.array;

import java.util.Arrays;

public class RangeSumQueryImmutable {
	static class NumArray {

		private final int[] nums;

		public NumArray(int[] nums) {
			this.nums = Arrays.copyOf(nums, nums.length);
		}

		public int sumRange(int i, int j) {
			if(i<0 || j>=nums.length){
				return 0;
			}
			int sum = 0;
			for(int index=i; index<=j; index++){
				sum+=nums[index];
			}
			return sum;
		}
	}

	public static void main(String[] args) {
		NumArray n = new NumArray(new int[]{1,2,3,4,5});
		System.out.println(n.sumRange(0,4));
	}
}
