package leetcode.leetcode_by_topics.string;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInStringII {

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInStringII s = new RemoveAllAdjacentDuplicatesInStringII();
        s.removeDuplicates("deeedbbcccbdaa", 3);
    }

    public String removeDuplicates(String s, int k) {
        if (s.length() < k) {
            return s;
        }

        int[] count = new int[s.length()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            count[i] = 1 + (i > 0 && !stack.isEmpty() && s.charAt(stack.peek()) == s.charAt(i)
                ? count[stack.peek()]
                : 0);

            if (count[i] == k) {
                for (int j = 0; j < k - 1; j++) {
                    stack.pop();
                }
            }
            else {
                stack.push(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int index : stack) {
            sb.append(s.charAt(index));
        }

        return sb.toString();
    }
}
