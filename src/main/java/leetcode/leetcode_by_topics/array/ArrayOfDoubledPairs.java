package leetcode.leetcode_by_topics.array;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ArrayOfDoubledPairs {

    public static void main(String[] args) {
        ArrayOfDoubledPairs s = new ArrayOfDoubledPairs();
        s.canReorderDoubled(new int[] {-8, -4, -2, -1, 0, 0, 1, 2, 4, 8});
    }

    public boolean canReorderDoubled(int[] arr) {
        if (arr.length % 2 != 0) {
            return false;
        }

        Map<Integer, Integer> map = new TreeMap<>();
        for (int v : arr) {
            map.put(v, map.getOrDefault(v, 0) + 1);
        }

        for (int v : map.keySet()) {
            if (map.get(v) == 0) {
                continue;
            }

            if (v < 0 && v % 2 != 0) {
                return false;
            }

            int count = map.get(v);
            int pairVal = v > 0 ? v * 2 : v / 2;

            if (!map.containsKey(pairVal) || count > map.get(pairVal)) {
                return false;
            }

            map.put(pairVal, map.get(pairVal) - count);
        }

        return true;
    }
}
