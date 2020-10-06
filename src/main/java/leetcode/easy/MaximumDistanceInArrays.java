package leetcode.easy;

public class MaximumDistanceInArrays {
	public static void main(String[] args) {
		int[][] m = {
				{1, 2, 3},
				{4, 5},
				{1, 2, 3}
		};
		System.out.println(maxDistance(m) == 4);
	}

	public static int maxDistance(int[][] a) {
		int result = Integer.MIN_VALUE;

		int min = a[0][0];
		int max = a[0][a[0].length - 1];

		int value, first, last;
		for (int i = 1; i < a.length; i++) {
			// Now you can pick up two integers from two different arrays
			// (each array picks one) and calculate the distance
			first = a[i][0];
			last = a[i][a[i].length -1];
			// 1
			value = Math.abs( first - max);
			if(value > result) {
				result = value;
			}
			// 2
			value = Math.abs(last - min);
			if (value > result) {
				result = value;
			}
			max = Math.max(max, last);
			min = Math.min(min, first);
		}

		return result;
	}
}
