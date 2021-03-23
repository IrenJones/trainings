package leetcode.leetcode_by_topics.graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BinaryTreesWithFactors {

	public static void main(String[] args) {
		BinaryTreesWithFactors s = new BinaryTreesWithFactors();
		s.numFactoredBinaryTrees(new int[]{18, 3, 6, 2});
	}

	long result = 0;

	public int numFactoredBinaryTrees(int[] arr) {
		if (arr.length == 1) {
			return 1;
		}

		int MOD_VALUE = 1_000_000_007;
		Arrays.sort(arr);
		long[] dp = new long[arr.length];
		// default main root without children
		Arrays.fill(dp, 1);

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], i);
		}

		for (int root = 0; root < arr.length; root++) {
			for (int child = 0; child < root; child++) {
				if (arr[root] % arr[child] == 0) {
					int anotherChild = arr[root] / arr[child];
					if (map.containsKey(anotherChild)) {
						dp[root] = (dp[root] + dp[child] * dp[map.get(anotherChild)]) % MOD_VALUE;
					}
				}
			}
		}

		for (long v : dp) {
			result += v;
		}
		return (int) (result % MOD_VALUE);
	}
}
