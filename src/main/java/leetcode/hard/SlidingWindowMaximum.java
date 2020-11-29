package leetcode.hard;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
		maxSlidingWindow(new int[]{-1, 1}, 1);
		maxSlidingWindow(new int[]{9, 11}, 2);
	}

	public static int[] maxSlidingWindow(int[] nums, int k) {
		List<Integer> list = new ArrayList<>();
		Deque<Integer> deq = new LinkedList<>();
		for (int index = 0; index < nums.length; index++) {
			// remove numbers out of range k
			while (!deq.isEmpty() && deq.peek() <= index - k) {
				deq.pollFirst();
			}
			// remove smaller numbers in k range as they are useless
			while (!deq.isEmpty() && nums[deq.peekLast()] < nums[index]) {
				deq.pollLast();
			}
			deq.add(index);
			if (index >= k - 1) {
				list.add(nums[deq.peek()]);
			}
		}
		return list.stream()
				.mapToInt(v -> v)
				.toArray();
	}
}
