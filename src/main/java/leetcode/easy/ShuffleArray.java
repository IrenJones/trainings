package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShuffleArray {

	public int[] shuffle(int[] nums, int n) {
		int[] res = new int[2*n];
		for(int i=0; i< 2*n; i+=2){
			res[i] = nums[i/2];
			res[i+1] = nums[i/2+n];
		}
		return res;
	}

	public void example() {
		Queue<Integer> queue = new LinkedList<>();

		int[] ints = queue.stream()
				.mapToInt(v -> v.intValue())
				.toArray();

		Queue<Integer> q = new LinkedList<>(
				IntStream.of(ints)
						.boxed()
						.collect(Collectors.toList())
		);
	}
}
