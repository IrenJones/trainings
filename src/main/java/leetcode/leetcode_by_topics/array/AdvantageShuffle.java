package leetcode.leetcode_by_topics.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class AdvantageShuffle {

    public static void main(String[] args) {
        AdvantageShuffle s = new AdvantageShuffle();
//        s.advantageCount(new int[]{718967141,189971378,341560426,23521218,339517772},
//            new int[]{967482459,978798455,744530040,3454610,940238504});
        s.advantageCountBetter(new int[] {8, 2, 4, 4, 5, 6, 6, 0, 4, 7}, new int[] {0, 8, 7, 4, 4, 2, 8, 5, 2, 0});
        s.advantageCount(new int[] {8, 2, 4, 4, 5, 6, 6, 0, 4, 7}, new int[] {0, 8, 7, 4, 4, 2, 8, 5, 2, 0});
    }

    public int[] advantageCount(int[] A, int[] B) {
        int n = A.length;
        if (n == 1) {
            return A;
        }

        int[] res = new int[n];
        Arrays.sort(A);
        PriorityQueue<Pair> queue = new PriorityQueue<>(
            Comparator.comparingInt(Pair::getKey).reversed()
        );
        for (int i = 0; i < n; i++) {
            queue.add(new Pair(B[i], i));
        }

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            res[p.getValue()] = findValue(A, p.getKey());
        }

        return res;
    }

    public int findValue(int[] a, int value) {
        int index = a.length - 1;
        while (a[index] == Integer.MIN_VALUE) {
            index--;
        }
        if (a[index] <= value) {
            index = 0;
            while (a[index] == Integer.MIN_VALUE) {
                index++;
            }
        }

        int res = a[index];
        a[index] = Integer.MIN_VALUE;
        return res;
    }

    class Pair {
        Integer key;
        Integer value;

        public Pair(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public Integer getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }
    }

    public int[] advantageCountBetter(int[] A, int[] B) {
        int n = A.length;
        if (n == 1) {
            return A;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int value : A) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        int[] res = new int[n];

        for (int index = 0; index < n; index++) {
            Integer key = map.higherKey(B[index]);
            if (key == null) {
                key = map.firstKey();
            }
            if (map.get(key) > 1) {
                map.put(key, map.get(key) - 1);
            }
            else {
                map.remove(key);
            }
            res[index] = key;
        }

        return res;
    }

}
