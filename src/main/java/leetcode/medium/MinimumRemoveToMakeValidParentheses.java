package leetcode.medium;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {

	public static void main(String[] args) {
		System.out.println(minRemoveToMakeValid("lee(t(c)o)de)").equals("lee(t(c)o)de"));
		System.out.println(minRemoveToMakeValid("a)b(c)d").equals("ab(c)d"));
		System.out.println(minRemoveToMakeValid("(a(b(c)d)").equals("a(b(c)d)"));
		System.out.println(minRemoveToMakeValid("))((").equals(""));
	}

	public static String minRemoveToMakeValid(String s) {
		Stack<Integer> indOpen = new Stack<>();
		Stack<Integer> indClose = new Stack<>();

		for(int i = 0; i< s.length(); i++) {
			if(s.charAt(i) == '(') {
				indOpen.push(i);
			}

			if(s.charAt(i) == ')') {
				if(indOpen.isEmpty()) {
					indClose.push(i);
				} else {
					indOpen.pop();
				}
			}
		}

		if(indOpen.isEmpty() && indClose.isEmpty()) {
			return s;
		}

		StringBuilder sb = new StringBuilder();
		for(int i=0; i < s.length(); i++) {
			if(!indOpen.contains(i) && !indClose.contains(i)) {
				sb.append(s.charAt(i));
			}
		}

		return sb.toString();
	}
}
