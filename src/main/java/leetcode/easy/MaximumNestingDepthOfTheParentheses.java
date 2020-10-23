package leetcode.easy;

public class MaximumNestingDepthOfTheParentheses {

	public static void main(String[] args) {
		System.out.println(maxDepth("1+(2*3)/(2-1)") == 1);
		System.out.println(maxDepth("(1+(2*3)+((8)/4))+1") == 3);
	}

	public static int maxDepth(String s) {
		int result = 0;
		int currentOpen = 0;

		for(int i=0; i< s.length(); i++) {
			if(s.charAt(i) == '(') {
				currentOpen++;
			} else if(s.charAt(i) == ')') {
				result = Math.max(result, currentOpen);
				currentOpen--;
			}
		}
		return result;
	}
}
