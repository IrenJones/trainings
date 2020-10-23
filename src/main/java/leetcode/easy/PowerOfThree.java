package leetcode.easy;

public class PowerOfThree {
	public static void main(String[] args) {
		System.out.println(isPowerOfThree(27) == true);
	}

	public static boolean isPowerOfThree(int n) {
		if (n == 0) {
			return false;
		}

		int powCalculated = (int) (Math.log10(n) / Math.log10(3));
		return n == (int)Math.pow(3, powCalculated);
	}
}
