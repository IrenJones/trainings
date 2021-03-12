package leetcode.medium;

public class IntegerReplacement {

	public static void main(String[] args) {
		IntegerReplacement solution = new IntegerReplacement();
		solution.integerReplacement(2147483647);
	}

	int count = Integer.MAX_VALUE;

	public int integerReplacement(int n) {

		backTracking((long)n, 0);

		return count;
	}

	public void backTracking(long n, int operationsNumber) {
		if(n == 1) {
			count = Math.min(count, operationsNumber);
		} else if( n > 1) {
			if(n % 2 == 0) {
				backTracking(n / 2, operationsNumber + 1);
			} else {
				backTracking(n + 1, operationsNumber + 1);
				backTracking(n - 1, operationsNumber + 1);
			}
		}
	}

}
