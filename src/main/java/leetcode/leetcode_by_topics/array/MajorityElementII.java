package leetcode.leetcode_by_topics.array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {
        int threshold = (int) Math.floor(nums.length * 1.0 / 3);

        Map<Integer, Integer> map = new HashMap<>();

        for(int v: nums){
            map.put(v, map.getOrDefault(v, 0) + 1);
        }

        return map.entrySet().stream()
            .filter( e -> e.getValue() > threshold)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }
}
