package leetcode.leetcode_by_topics.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum s = new ThreeSum();
        s.threeSum(new int[] {-1, 0, 1, 2, -1, -4});
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
                        int mid = -min - max;
                        res.put("" + min + "_" + mid + "_" + max, Arrays.asList(min, mid, max));
                    }
                }
            }
        }

        return res.size() == 0
            ? new ArrayList()
            : new ArrayList<>(res.values());
    }

    public List<List<Integer>> threeSumFaster(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3){
            return res;
        }

        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n - 2; i++){
            while(i > 0 && i < n - 2 && nums[i] == nums[i - 1]){
                i++;
            }

            int j = i + 1, k = n - 1;
            while(j < k){
                if(nums[i] + nums[j] + nums[k] == 0){
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j - 1]){
                        j++;
                    }
                    while(j < k && nums[k] == nums[k + 1]){
                        k--;
                    }
                } else if(nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else{
                    k--;
                }
            }
        }
        return res;
    }
}
