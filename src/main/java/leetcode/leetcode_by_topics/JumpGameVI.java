package leetcode.leetcode_by_topics;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class JumpGameVI {

    public static void main(String[] args) {
        JumpGameVI s = new JumpGameVI();
        s.maxResultBetter(new int[]{10,-5,-2,4,0,3}, 3);
    }

    // TLE
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];

        if(n == 1) {
            return dp[0];
        }

        int res;
        for(int i = 1; i < n; i++) {
            res = i - 1;
            for (int j = Math.max(0, i - k); j <= i - 1; j++) {
                res = dp[res] < dp[j] ? j : res;
            }
            dp[i] = dp[res] + nums[i];
        }

        return dp[n-1];
    }


    public int maxResultBetter(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];

        if(n == 1) {
            return dp[0];
        }

        TreeMap<Integer, Integer> heap = new TreeMap<>();
        heap.put(dp[0], 1);

        for(int i = 1; i < n; i++) {
            if(i > k){
                if(heap.get(dp[i - 1 - k]) == 1){
                    heap.remove(dp[i - 1 - k]);
                } else {
                    heap.put(dp[i - 1 - k], heap.get(dp[i - 1 - k]) - 1);
                }
            }

            dp[i] = heap.lastKey() + nums[i];
            heap.put(dp[i], heap.getOrDefault(dp[i], 0) + 1);
        }

        return dp[n-1];
    }
}
