package leetcode.leetcode_by_topics.array;

import java.util.HashMap;
import java.util.Map;

public class ThreeSumWithMultiplicity {

    public static void main(String[] args) {
        ThreeSumWithMultiplicity s = new ThreeSumWithMultiplicity();
        s.threeSumMulti(new int[] {1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8);
    }

    public static final int MODULO = 1_000_000_007;

    public int threeSumMulti(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;

        long result = 0;

        map.put(arr[0], 1);

        for (int j = 1; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                if (map.containsKey(target - arr[j] - arr[k])) {
                    result += (long)map.get(target - arr[j] - arr[k]);
                }
            }
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
        }

        return (int)(result % MODULO);
    }
}
