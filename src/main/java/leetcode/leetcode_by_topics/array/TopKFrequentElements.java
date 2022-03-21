package leetcode.leetcode_by_topics.array;

import java.util.*;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Comparator<Map.Entry<Integer, Integer>> comparator = Comparator.comparingInt((Map.Entry<Integer, Integer> p) -> p.getValue()).reversed();
        Map<Integer, Integer> freq = new HashMap<>();

        for(int num: nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        return freq.entrySet().stream().sorted(comparator).limit(k).map(Map.Entry::getKey).mapToInt(v -> v).toArray();
    }
}
