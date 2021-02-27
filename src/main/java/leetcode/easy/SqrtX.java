package leetcode.easy;

public class SqrtX {
	public int mySqrt(int x) {

		if (x == 0) {
			return 0;
		}

		int left = 1, right = Integer.MAX_VALUE;
		while (true) {
			int mid = left + (right - left) / 2;
			if ((long) mid * mid > (long) x) {
				right = mid - 1;
			} else {
				if ((long) (mid + 1) * (mid + 1) > (long) x) {
					return mid;
				}
				left = mid + 1;
			}
		}
	}
}
