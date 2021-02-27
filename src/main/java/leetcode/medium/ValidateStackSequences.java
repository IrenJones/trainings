package leetcode.medium;

import java.util.Stack;

public class ValidateStackSequences {

	public static void main(String[] args) {
		System.out.println(validateStackSequences(new int[]{2, 1, 0}, new int[]{1, 2, 0}));
	}


	public static boolean validateStackSequences(int[] pushed, int[] popped) {
		int indexPop = 0;
		Stack<Integer> stack = new Stack<>();
		for(int value: pushed) {

			stack.push(value);

			if(indexPop < popped.length) {
				while(!stack.isEmpty() && stack.peek() == popped[indexPop]) {
					stack.pop();
					indexPop++;
				}
			}
		}

		return pushed.length == 0 || indexPop >= popped.length && stack.isEmpty();
	}
}
