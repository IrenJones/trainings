package leetcode.leetcode_by_topics.array;

public class MinimumOperationsToMakeArrayEqual {
    public int minOperations(int n) {
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = 2 * i + 1;
        }

        int target = n % 2 == 1
            ? arr[n / 2]
            : (arr[n / 2 - 1] + arr[n / 2]) / 2;

        int count = 0;

        for (int i = 0; i < n / 2; i++) {
            count += Math.abs(target - arr[i]);
        }

        return count;
    }
}
