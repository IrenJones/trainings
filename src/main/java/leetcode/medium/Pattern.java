package leetcode.medium;

import scala.Array;

import java.util.Arrays;
import java.util.Stack;

public class Pattern {

	public static void main(String[] args) {
		//System.out.println(find132pattern(new int[]{1, 3, 2, 0, 4, -5, 6}));
		//System.out.println(find132pattern(new int[]{1, 0, 1, -4, -3}));
		System.out.println(find132pattern(new int[]{6, 22, 4, 3, 2, 1, 20}));
		System.out.println(find132pattern(new int[]{6, 22, 4, 12, 1, 13, 20}));
	}

	public static boolean find132pattern(int[] nums) {
		if(nums.length < 3 ) {
			return false;
		}
		Stack<Integer> stack = new Stack<>();
		int[] min = new int[nums.length];
		min[0] = nums[0];

		// define 1 in pattern
		for(int i=1; i< nums.length; i++) {
			min[i] = Math.min(nums[i], min[i-1]);
		}

		int index = nums.length-1;
		while(index >= 0){
			// define 2 in pattern
			if(nums[index] > min[index]) {

				// remove all values from stack that < '1'
				while(!stack.isEmpty() && min[index] >= stack.peek()){
					stack.pop();
				}
				// '3' > '2'
				if(!stack.isEmpty() && stack.peek() < nums[index]) {
					return true;
				}
				stack.push(nums[index]);
			}
			index--;
		}
		return false;
	}
}
