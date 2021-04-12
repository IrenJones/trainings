package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class CountGoodMeals {

    public static void main(String[] args) {
        CountGoodMeals s = new CountGoodMeals();
        s.countPairsBetter(new int[] {1, 3, 5, 7, 9});
    }

    // tle
    public int countPairs(int[] d) {
        long count = 0;

        for (int i = 0; i < d.length; i++) {
            for (int j = i + 1; j < d.length; j++) {
                if (isPowerOfTwo(d[i] + d[j])) {
                    count++;
                }
            }
        }

        return (int)count % 1_000_000_007;
    }

    public boolean isPowerOfTwo(int n) {
        if (n > 0 && ((n - 1) & n) == 0) {
            return true;
        }
        return false;
    }

    public int countPairsBetter(int[] d) {
        long count = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < d.length; i++) {
            for (int n = 0; n < 22; n++) {
                int v = (int)Math.pow(2, n);
                if (map.containsKey(v - d[i])) {
                    count += map.get(v - d[i]);
                    count = count % 1_000_000_007;
                }
            }
            map.put(d[i], map.getOrDefault(d[i], 0) + 1);
        }

        return (int)count;
    }
}
