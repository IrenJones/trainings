package leetcode.leetcode_by_topics.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum s = new ThreeSum();
        s.threeSum(new int[]{-1,0,1,2,-1,-4});
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        Map<String, List<Integer>> res = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey(-nums[i] - nums[j])) {
                    int count = map.get(-nums[i] - nums[j]);
                    if (nums[i] == -nums[i] - nums[j]) {
                        count--;
                    }
                    if (nums[j] == -nums[i] - nums[j]) {
                        count--;
                    }

                    if (count > 0) {
                        int min = Math.min(nums[i], Math.min(nums[j], -nums[i] - nums[j]));
                        int max = Math.max(nums[i], Math.max(nums[j], -nums[i] - nums[j]));
                        int mid = - min - max;
                        res.put("" + min + "_" + mid + "_" + max, Arrays.asList(min, mid, max));
                    }
                }
            }
        }

        return res.size() == 0
            ? new ArrayList()
            : new ArrayList<>(res.values());
    }
}
