package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class BeautifulArrangement {

    int res = 0;

    // use array instead of set - more effective
    public int countArrangement(int n) {
        if (n == 1) {
            return 1;
        }

        calculate(n, 1, new HashSet<>());

        return res;
    }

    public void calculate(int n, int i, Set<Integer> cur) {
        if (cur.size() == n) {
            res++;
            return;
        }

        for (int j = 1; j <= n; j++) {
            if (!cur.contains(j) && (j % i == 0 || i % j == 0)) {
                cur.add(j);
                calculate(n, i + 1, new HashSet<>(cur));
                cur.remove(j);
            }
        }
    }
}
