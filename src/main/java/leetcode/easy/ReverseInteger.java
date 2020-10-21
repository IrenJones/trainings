package leetcode.easy;

public class ReverseInteger {
	public int reverse(int x) {

		int sign = 1;

		// make x positive if not
		if (x < 0) {
			sign*= -1;
			x*= -1;
		}

		int result = 0;
		int current = x;
		int tmp;
		while(current > 0) {
			tmp = current % 10;
			// to prevent overflow
			if(sign > 0 && (result > Integer.MAX_VALUE/10 ||
					result == Integer.MAX_VALUE/10 && tmp > Integer.MAX_VALUE % 10) ||
					sign < 0 && (sign * result < Integer.MIN_VALUE/10 ||
							sign * result == Integer.MIN_VALUE/10 && sign * tmp < Integer.MIN_VALUE % 10)) {
				return 0;
			}
			result = result* 10 + tmp;
			current = current / 10;
		}

		return sign * result;
	}
}
