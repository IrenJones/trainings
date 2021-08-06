package leetcode.leetcode_by_topics.array;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReduceArraySizeToTheHalf {

    public static void main(String[] args) {
        ReduceArraySizeToTheHalf s = new ReduceArraySizeToTheHalf();
            s.minSetSize(new int[]{1, 9});
    }

    public int minSetSize(int[] arr) {
        int size = arr.length / 2;

        Map<Integer, Integer> map = new HashMap<>();
        for (int value : arr) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>(
            Comparator.comparingInt((Map.Entry<Integer, Integer> e) -> e.getValue()).reversed()
        );

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            q.offer(e);
        }
        int curSize = 0;
        int res = 0;
        while (curSize < size) {
            curSize += q.poll().getValue();
            res++;
        }
        return res;
    }
}
