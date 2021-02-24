package leetcode.medium;

import java.util.Stack;

public class ScoreOfParentheses {

	public static void main(String[] args) {
		ScoreOfParentheses solution = new ScoreOfParentheses();
		System.out.println(solution.scoreOfParentheses("()"));
		System.out.println(solution.scoreOfParentheses("()()"));
		System.out.println(solution.scoreOfParentheses("(())"));
		System.out.println(solution.scoreOfParentheses("(()(()))"));
	}

	public int scoreOfParentheses(String S) {
		Stack<Integer> stack = new Stack<>();

		for(int i = 0; i < S.length(); i++) {
			if(S.charAt(i) == '(') {
				stack.push(0);
			} else {
				if(!stack.isEmpty()) {
					int sum = 0;
					while(stack.peek() != 0) {
						sum += stack.pop();
					}
					stack.pop();
					stack.push( sum > 0 ? sum * 2 : 1);
				}
			}
		}

		int result = 0;
		if(stack.size() > 0) {
			while (!stack.isEmpty()) {
				result += stack.pop();
			}
		}

		return result;
	}
}
