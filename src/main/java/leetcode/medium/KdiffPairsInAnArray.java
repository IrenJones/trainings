package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class KdiffPairsInAnArray {

	public static void main(String[] args) {
		System.out.println(findPairs(new int[]{3,1,4,1,5}, 2) == 2);
		System.out.println(findPairs(new int[]{1,2,3,4,5}, 1) == 4);
		System.out.println(findPairs(new int[]{1,3,1,5,4}, 0) == 1);
		System.out.println(findPairs(new int[]{1,2,4,4,3,3,0,9,2,3}, 3) == 2);
		System.out.println(findPairs(new int[]{1,2,4,4,3,3,0,9,2,3}, 3) == 2);
	}

	public static int findPairs(int[] nums, int k) {
		Map<Integer, Integer> result = new HashMap<>();
		for(int i =0; i< nums.length; i++){
			for(int j = i + 1; j < nums.length; j++){
				if(nums[j] - k == nums[i]) {
					result.putIfAbsent(nums[i], nums[j]);
				} else if(nums[i] - k == nums[j]){
					result.putIfAbsent(nums[j], nums[i]);
				}
			}
		}
		return result.size();
	}

	public static int findPairsBetter(int[] nums, int k) {
		Map<Integer, Integer> result = new HashMap<>();

		for(int i=0;i < nums.length; i++){
			result.put(nums[i], result.getOrDefault(nums[i], 0) + 1);
		}

		int count = 0;
		for(Map.Entry<Integer, Integer> e : result.entrySet()) {
			if(k == 0){
				if(e.getValue() >= 2){
					count++;
				}
			} else if(result.containsKey(e.getKey() + k)){
				count++;
			}
		}
		return count;
	}
}
