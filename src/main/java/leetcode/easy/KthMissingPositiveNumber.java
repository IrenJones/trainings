package leetcode.easy;

public class KthMissingPositiveNumber {

	public static void main(String[] args) {
		findKthPositive(new int[]{1, 2}, 1);
	}

	public static int findKthPositive(int[] arr, int k) {
		int i = 0;
		int number = 1;
		for (int n = 1; n < arr[arr.length - 1]; n++) {
			if (k == 1) {
				return number;
			}
			if (i > arr.length - 1 || arr[i] != n) {
				k--;
				number = n;
			} else {
				i++;
			}
		}

		if (k > 1) {
			number = arr[i] + k;
		}
		return number;
	}
}
