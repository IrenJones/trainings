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
		Stack<Integer> indexes = new Stack<>();
		Stack<Integer> indexesToFix = new Stack<>();

		for(int i=0; i< s.length(); i++){
			if(s.charAt(i) == '(') {
				indexes.push(i);
			} else if(s.charAt(i) == ')') {
				if(indexes.isEmpty()) {
					indexesToFix.push(i);
				} else {
					indexes.pop();
				}
			}
		}

		if(indexes.isEmpty() && indexesToFix.isEmpty()) {
			return s;
		}

		StringBuilder sb = new StringBuilder();
		for(int i=0; i< s.length(); i++) {
			if(!indexes.contains(i) && !indexesToFix.contains(i)){
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}
}
