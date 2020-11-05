package leetcode.easy;

public class Maximum69Number {

	public int maximum69Number(int num) {
		return Integer.parseInt(Integer.toString(num).replaceFirst("6", "9"));
	}
}
