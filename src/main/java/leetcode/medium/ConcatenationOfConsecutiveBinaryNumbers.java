package leetcode.medium;

public class ConcatenationOfConsecutiveBinaryNumbers {

	public static void main(String[] args) {
		concatenatedBinary(5);
	}

	public static int concatenatedBinary(int n) {
		long result = 0;
		for (int i = 1; i <= n; i++) {
			String binary = Integer.toBinaryString(i);
			result = ((result << binary.length()) + i) % 1000000007;
		}
		return (int) result;
	}
}
