package leetcode.leetcode_by_topics.string;

public class ReverseInteger {
	public static void main(String[] args) {
		System.out.println(reverse(1534236469));
	}
	public static int reverse(int x) {
		int result = 0;
		int add = x < 0? -1: 1;
		x = x * add;
		while(x > 0){
			if (result > Integer.MAX_VALUE/10 || result == Integer.MAX_VALUE / 10 && x%10 > Integer.MAX_VALUE%10 ||
						-result < Integer.MIN_VALUE/10 || -result == Integer.MIN_VALUE / 10 && -x%10 < Integer.MIN_VALUE%10){
				return 0;
			} else{
				result = result*10 + x%10;
			};
			x = x/10;
		}
		return add * result;
	}
}
