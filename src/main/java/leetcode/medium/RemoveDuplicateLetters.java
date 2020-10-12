package leetcode.medium;

import java.util.Stack;

public class RemoveDuplicateLetters {
	public static void main(String[] args) {
		System.out.println(removeDuplicateLetters("cbdaacdcbc").equals("acdb"));
	}

	public static String removeDuplicateLetters(String s) {
		int index;
		Stack<Integer> stack = new Stack<>();
		int[] lastPosition = new int[26];
		int[] visited = new int[26];

		// determine the last position of each letter
		for (int i = 0; i < s.length(); i++) {
			index = s.charAt(i) - 'a';
			lastPosition[index] = i;
		}

		for (int i = 0; i < s.length(); i++) {
			index = s.charAt(i) - 'a';
			if (visited[index] == 0) {
				while (!stack.isEmpty() &&
						index < stack.peek() &&
						i < lastPosition[stack.peek()]) {
					// pop the last if we meet the smaller value
					int latest = stack.pop();
					visited[latest] = 0;
				}
				stack.push(index);
			}
			visited[index]++;
		}
		StringBuilder result = new StringBuilder();
		char c;
		for (int value : stack) {
			c = (char)('a' + value);
			result.append(c);
		}
		return result.toString();
	}
}
