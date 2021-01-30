package leetcode.medium;

import scala.Char;

public class SmallestStringWithGivenNumericValue {

	public static void main(String[] args) {
		getSmallestString(5, 73);
		getSmallestString(3, 27);
	}

	public static String getSmallestString(int n, int k) {
		StringBuilder sb = new StringBuilder();
		int minPossible = n - 1;
		while (k > 0){
			if(k == minPossible){
				while (k > 0) {
					sb.append('a');
					k--;
				}
			}

			if(k == 0) {
				break;
			}

			int cur = k - minPossible;
			if(cur >= 26) {
				k -= 26;
				sb.append('z');
			} else {
				sb.append((char)('a' + cur - 1));
				k -= cur;
			}
			minPossible = (n - sb.length() - 1);
		}
		return sb.reverse().toString();
	}
}
