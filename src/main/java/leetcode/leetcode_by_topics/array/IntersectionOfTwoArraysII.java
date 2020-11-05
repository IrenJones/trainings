package leetcode.leetcode_by_topics.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {

	public int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> result = new ArrayList<>();

		if (nums2.length > nums1.length) {
			fill(map, nums2);
			check(result, map, nums1);
		} else {
			fill(map, nums1);
			check(result, map, nums2);
		}

		return result.stream()
				.mapToInt(v -> v)
				.toArray();
	}

	public void fill(Map<Integer, Integer> map, int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
	}

	public void check(List<Integer> res, Map<Integer, Integer> map, int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				if (map.get(arr[i]) > 0) {
					map.put(arr[i], map.get(arr[i]) - 1);
					res.add(arr[i]);
				}
			}
		}
	}

	// if sorted
	public int[] intersectTwoPointers(int[] nums1, int[] nums2) {
		List<Integer> result = new ArrayList<>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int size1 = nums1.length;
		int size2 = nums2.length;
		int i = 0, j = 0;

		while (i < size1 && j < size2) {
			if (nums1[i] == nums2[j]) {
				result.add(nums1[i]);
				i++;
				j++;
			} else if (nums1[i] > nums2[j]) {
				j++;
			} else {
				i++;
			}
		}

		return result.stream()
				.mapToInt(v -> v)
				.toArray();
	}
}
