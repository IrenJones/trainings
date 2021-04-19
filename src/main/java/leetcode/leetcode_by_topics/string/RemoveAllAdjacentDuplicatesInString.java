package leetcode.leetcode_by_topics.string;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {

    public String removeDuplicates(String s) {
        if (s.length() < 2) {
            return s;
        }

        StringBuilder sb = new StringBuilder(s);
        while (true) {
            int size = sb.length();

            for (int i = 0; i < sb.length() - 1; i++) {
                if (sb.charAt(i) == sb.charAt(i + 1)) {
                    sb.deleteCharAt(i);
                    sb.deleteCharAt(i);
                }
            }

            if (sb.length() == size) {
                return sb.toString();
            }
        }
    }

    public String removeDuplicatesBetter(String s) {
        if (s.length() < 2) {
            return s;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            }
            else {
                if (stack.peek() == s.charAt(i)) {
                    stack.pop();
                }
                else {
                    stack.push(s.charAt(i));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
