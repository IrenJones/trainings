package leetcode.leetcode_by_topics.math;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();

        combine(n, k, new ArrayList<>(), 1, res);

        return res;
    }

    public void combine(int sum, int k, List<Integer> cur, int start, List<List<Integer>> res) {
        if (sum == 0 && k == 0) {
            res.add(cur);
            return;
        } else if (sum > 0 && k > 0) {
            for (int i = start; i < 10; i++) {
                if (sum - i >= 0) {
                    cur.add(i);
                    combine(sum - i, k - 1, new ArrayList<>(cur), i + 1, res);
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }
}
