package leetcode.leetcode_by_topics.array;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

	public int[] topKFrequent(int[] nums, int k) {
		PriorityQueue<Pair> queue = new PriorityQueue<Pair>(Comparator.comparingInt(Pair::getCount).reversed());

		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}

		map.entrySet().forEach( e ->
				{
					queue.add(new Pair(e.getKey(), e.getValue()));
				}
		);

		int[] res = new int[k];
		for(int i=0; i< k; i++) {
			res[i] = queue.poll().value;
		}

		return res;
	}

	class Pair{
		int value;
		int count;

		public Pair(int value, int count) {
			this.value = value;
			this.count = count;
		}

		public int getCount(){
			return this.count;
		}
	}
}
