package leetcode.leetcode_by_topics.array;

import java.util.Stack;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        if (T.length == 0) {
            return new int[0];
        }

        int n = T.length;
        int[] res = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (T[i] < T[j]) {
                    res[i] = j - i;
                    break;
                }
            }
        }

        return res;
    }

    public int[] dailyTemperaturesViaStack(int[] T) {
        if (T.length == 0) {
            return new int[0];
        }

        int n = T.length;
        int[] res = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            while (!stack.isEmpty() && T[i] > T[stack.peek()]){
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }

        return res;
    }
}
