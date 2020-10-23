package leetcode.easy;

public class PowerOfFour {

	public static void main(String[] args) {
		System.out.println(isPowerOfFourLoop(16)); // true
		System.out.println(isPowerOfFour(16)); // true
	}

	public static boolean isPowerOfFourLoop(int num) {
		if (num == 0) {
			return false;
		}
		while (num % 4 == 0) {
			num = num / 4;
		}
		return num == 1;
	}

	public static boolean isPowerOfFour(int num) {
		if (num == 0) {
			return false;
		}

		int powCalculated = (int) (Math.log10(num) / Math.log10(4));
		return num == Math.pow(4, powCalculated);
	}
}
