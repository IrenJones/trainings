package leetcode.medium;

public class ArithmeticSlices {


	public static void main(String[] args) {
		ArithmeticSlices solution = new ArithmeticSlices();
		solution.numberOfArithmeticSlices(new int[]{1,2,3,4});
	}
	public int numberOfArithmeticSlices(int[] A) {

		if(A.length == 0) {
			return 0;
		}

		int[] dp = new int[A.length];
		int sum = 0;

		for(int i = 2; i < A.length; i++) {
			if(A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
				dp[i] = 1 + dp[i - 1];
				sum += dp[i];
			}
		}

		return sum;
	}
}
