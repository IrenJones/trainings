package leetcode.medium;

public class LongestMountainInArray {

	public static void main(String[] args) {
		System.out.println(longestMountain(new int[]{9,8,7,6,5,4,3}) == 0);
		System.out.println(longestMountain(new int[]{0,1,2,3,4,5,4,3,2,1,0}) == 11);
		System.out.println(longestMountain(new int[]{2, 1, 4, 7, 3, 2, 5}) == 5);
		System.out.println(longestMountain(new int[]{2, 2, 2}) == 0);
	}

	public static int longestMountain(int[] A) {
		if (A.length < 3) {
			return 0;
		}

		int maxLen = 0;
		int upLen = 0;
		int downLen = 0;

		for (int i = 1; i < A.length; i++) {
			// mountain! or flat
			if (downLen > 0 && A[i - 1] < A[i] || A[i] == A[i - 1]) {
				upLen = 0;
				downLen = 0;
			}

			if (A[i - 1] < A[i]) {
				upLen++;
			}
			if (A[i - 1] > A[i]) {
				downLen++;
			}

			if (upLen > 0 && downLen > 0) {
				maxLen = Math.max(upLen + downLen + 1, maxLen);
			}
		}
		return maxLen;
	}
}
