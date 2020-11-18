package leetcode.leetcode_by_topics.array;

import java.util.Arrays;

public class AbsoluteDifferenceTwoArrays {

	public static void main(String[] args) {
		int A[] = {1, 2, 11, 5};
		int B[] = {4, 12, 19, 23, 127, 235};

		findDifference(A, B);
	}

	public static int findDifference(int [] arr1, int[] arr2) {
		if(arr1.length == 0 || arr2.length == 0) {
			return 0;
		}
		Arrays.sort(arr1);
		Arrays.sort(arr2);

		int result = Integer.MAX_VALUE;
		int i =0, j = 0;

		while(i < arr1.length && j < arr2.length) {
			if(Math.abs(arr1[i] - arr2[j]) < result) {
				result = Math.abs(arr1[i] - arr2[j]);
			}

			if(arr1[i] < arr2[j]) {
				i++;
			} else {
				j++;
			}
		}

		return result;
	}
}
