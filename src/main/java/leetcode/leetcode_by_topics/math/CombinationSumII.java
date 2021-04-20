package leetcode.leetcode_by_topics.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumII {

    Set<String> set = new HashSet<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();

        combine(candidates, target, 0, new ArrayList<>(), res);

        return res;
    }

    public void combine(int[] a, int sum, int start, List<Integer> cur, List<List<Integer>> res) {
        if (sum == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cur.size(); i++) {
                sb.append(cur.get(i)).append(".");
            }
            if (!set.contains(sb.toString())) {
                res.add(cur);
                set.add(sb.toString());
            }
            return;
        }

        for (int i = start; i < a.length; i++) {
            if (sum - a[i] >= 0) {
                cur.add(a[i]);
                combine(a, sum - a[i], i + 1, new ArrayList<>(cur), res);
                cur.remove(cur.size() - 1);
            }
        }
    }

    /* More effective way to solve the problem */

    public List<List<Integer>> combinationSum2Better(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();

        combineBetter(candidates, target, 0, new ArrayList<>(), res);

        return res;
    }

    private void combineBetter(int[] a, int sum, int start, List<Integer> cur, List<List<Integer>> res) {
        if (sum == 0) {
            res.add(cur);
            return;
        }

        for (int i = start; i < a.length; i++) {
            if(i > start && a[i] == a[i - 1]){
                continue;
            } else if (sum - a[i] >= 0) {
                cur.add(a[i]);
                combine(a, sum - a[i], i + 1, new ArrayList<>(cur), res);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
