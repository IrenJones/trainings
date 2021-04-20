package leetcode.leetcode_by_topics.math;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static void main(String[] args) {
        Combinations s = new Combinations();
        s.combine(4, 2);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        combine(1, k, n, res, new ArrayList<>());

        return res;
    }

    public void combine(int i, int k, int n, List<List<Integer>> res, List<Integer> cur) {
        if (cur.size() == k) {
            res.add(cur);
            return;
        }

        for (int j = i; j <= n; j++) {
            cur.add(j);
            combine(j + 1, k, n, res, new ArrayList<>(cur));
            cur.remove(cur.size() - 1);
        }
    }
}
