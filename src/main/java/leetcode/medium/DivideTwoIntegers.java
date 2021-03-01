package leetcode.medium;

public class DivideTwoIntegers {

	public static void main(String[] args) {
		System.out.println(divideAgain(-2147483648, 1));
		divide(-2147483648, 1);
	}

	public static int divideReadableVersion(int A, int B) {
		if (A == 0) {
			return 0;
		}

		// possible overflow
		if (A == Integer.MIN_VALUE && B == -1) {
			return Integer.MAX_VALUE;
		}

		int a = Math.abs(A);
		int b = Math.abs(B);

		int result = 0;
		// Approach : Keep subtracting the divisor from the dividend until dividend becomes less than divisor.
		// The dividend becomes the remainder, and the number of times subtraction is done becomes the quotient.
		while (a - b >= 0) {
			int current = 1;
			int partB = b;

			while (a - partB * 2 > 0) {
				partB = partB * 2;
				current = current * 2;
			}
			a = a - partB;
			result += current;
		}

		// so silly check because in that case with all restrictions we cannot just check it via A*B > 0
		return (A > 0) == (B > 0)
				? result
				: -result;
	}


	public static int divide(int A, int B) {
		if (A == 0) {
			return 0;
		}

		// possible overflow
		if (A == Integer.MIN_VALUE && B == -1) {
			return Integer.MAX_VALUE;
		}

		int a = Math.abs(A);
		int b = Math.abs(B);

		int result = 0;
		while (a - b >= 0) {
			int current = 1;
			int partB = b;

			while (a - (partB << 1) > 0) {
				partB = partB << 1;
				current = current << 1;
			}
			a = a - partB;
			result += current;
		}

		// so silly check because in that case with all restrictions we cannot just check it via A*B > 0
		return (A > 0) == (B > 0)
				? result
				: -result;
	}

	// doesn't work with overflow
	public static int divideAgain(int dividend, int divisor) {

		if(divisor == 1) {
			return dividend;
		}

		// possible overflow
		if (dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}

		int sign = (dividend > 0) == (divisor > 0)
				? 1
				: - 1;

		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);

		int quotient = 0;
		while (dividend >= divisor) {
			dividend -= divisor;
			quotient++;
		}

		return sign == 1
				? quotient
				: - quotient;
	}

}
