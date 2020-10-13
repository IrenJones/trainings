package leetcode.medium;

public class StringToInteger {
	public static void main(String[] args) {
		System.out.println(myAtoi("  -42") == -42);
		System.out.println(myAtoi("13") == 13);
		System.out.println(myAtoi("-91283472332") == Integer.MIN_VALUE);
		System.out.println(myAtoi("-2147483647") == -2147483647);
	}

	public static int myAtoi(String s) {

		if(s.length() == 0) {
			return 0;
		}

		int index = 0;
		int sign = 1;
		int result = 0;
		// find first non-whitespace symbol
		while(index < s.length() && s.charAt(index) == ' ') {
			index++;
		}

		// define sign
		if (index < s.length() && (s.charAt(index) == '-' || s.charAt(index) == '+')) {
			sign = s.charAt(index) == '-' ? -1 : 1;
			index++;
		}

		// define number
		while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
			if( checkLimitUp(sign, result, index, s) || checkLimitDown(sign, result, index, s)){
				return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			result = result * 10 + (s.charAt(index) - '0');
			index++;
		}

		return sign * result;
	}

	private static boolean checkLimitUp(int sign, int result, int index, String s) {
		return sign > 0 && (result > Integer.MAX_VALUE/10 ||
				result == Integer.MAX_VALUE/10 && s.charAt(index) - '0' > Integer.MAX_VALUE % 10);
	}

	private static boolean checkLimitDown(int sign, int result, int index, String s) {
		return sign < 0 && (sign * result < Integer.MIN_VALUE/10 ||
				sign * result == Integer.MIN_VALUE/10 && sign * (s.charAt(index) - '0') < Integer.MIN_VALUE % 10);
	}
}
