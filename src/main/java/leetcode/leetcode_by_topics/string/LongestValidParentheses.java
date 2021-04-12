package leetcode.leetcode_by_topics.string;

import java.util.Stack;

public class LongestValidParentheses {

    // TLE
    public int longestValidParentheses(String s) {
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int size = 2; i + size <= s.length(); size += 2) {
                if (valid(s.substring(i, i + size))) {
                    max = Math.max(max, size);
                }
            }
        }

        return max;
    }

    public boolean valid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        return stack.size() == 0;
    }

    //--------------------------------
    public int longestValidParenthesesElse(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push(i);
            } else {
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(i);
                } else{
                    max = Math.max(max, i - stack.peek());
                }
            }
        }

        return max;
    }
}
