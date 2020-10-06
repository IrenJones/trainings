package leetcode.medium;

import org.apache.commons.math3.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class RemoveCoveredIntervals {

	public static void main(String[] args) {
		int [][] arr = {{1,4},{3,6},{2,8}};
		System.out.println(removeCoveredIntervals(arr) == 2);
		int [][] arr1 = {{1,2},{1,4}, {3,4}};
		System.out.println(removeCoveredIntervals(arr1) == 1);
	}
	public static int removeCoveredIntervals(int[][] intervals) {
		Comparator<int[]> comparator = Comparator.comparingInt(arr -> arr[0]);
		Arrays.sort(intervals, comparator);
		int count = 0, left = -1, right = -1;
		for (int i = 0 ; i< intervals.length; i++) {
			if (intervals[i][0] > left && intervals[i][1] > right) {
				left = intervals[i][0];
				count++;
			}
			right = Math.max(right, intervals[i][1]);
		}
		return count;
	}
}
