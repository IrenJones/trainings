package leetcode.medium;

import java.util.Stack;

public class BasicCalculatorII {

	public static void main(String[] args) {
		calculate("4 + 3*3");
	}

	public static int calculate(String s) {
		int result = 0;
		if (s == null || s.length() == 0) {
			return result;
		}
		Stack<Integer> stack = new Stack<>();
		char lastOperation = '+';
		int currentNum = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				currentNum = 10 * currentNum + (c - '0');
			}
			if (i == s.length() - 1 || !Character.isWhitespace(c) && !Character.isDigit(c)) {
				if (lastOperation == '+') {
					stack.push(currentNum);
				} else if (lastOperation == '-') {
					stack.push(-currentNum);
				} else if (lastOperation == '*') {
					stack.push(stack.pop() * currentNum);
				} else {
					stack.push(stack.pop() / currentNum);
				}
				lastOperation = c;
				currentNum = 0;
			}
		}

		while (!stack.isEmpty()) {
			result += stack.pop();
		}

		return result;
	}
}
