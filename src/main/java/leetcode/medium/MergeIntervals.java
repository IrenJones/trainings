package leetcode.medium;

import edu.princeton.cs.algs4.In;
import org.apache.hadoop.io.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class MergeIntervals {
	public static void main(String[] args) {
		int[][] array = {
				{1,3},
				{2, 6},
				{5, 10},
				{11, 13}
		};
		merge(array);

		mergeRepeat(array);
	}

	public static int[][] merge(int[][] intervals) {
		if(intervals.length < 2) {
			return intervals;
		}
		Comparator<int[]> comparator = Comparator.comparingInt(array -> array[0]);

		Arrays.sort(intervals, comparator);

		Stack<Pair> stack = new Stack<>();
		stack.push(new Pair(intervals[0][0], intervals[0][1]));
		Pair prev;
		for(int i=1; i< intervals.length; i++) {
			prev = stack.peek();
			if(prev.getSecond() >= intervals[i][0]) {
				stack.pop();
				stack.push(new Pair(prev.getFirst(), Math.max(prev.getSecond(), intervals[i][1])));
			} else {
				stack.push(new Pair(intervals[i][0], intervals[i][1]));
			}
		}

		int[][] result = new int[stack.size()][2];
		int index = stack.size() - 1;
		while(!stack.isEmpty()) {
			prev = stack.pop();
			result[index--] = new int[]{prev.getFirst(), prev.getSecond()};
		}
		return result;
	}

	static class Pair{
		Integer n1;
		Integer n2;

		public Pair(Integer n1, Integer n2) {
			this.n1 = n1;
			this.n2 = n2;
		}

		public Integer getFirst(){
			return  this.n1;
		}

		public Integer getSecond(){
			return this.n2;
		}
	}


	public static int[][] mergeRepeat(int[][] intervals) {

		if(intervals.length < 2) {
			return intervals;
		}

		Comparator<int[]> comparator = Comparator.comparingInt(array -> array[0]);
		Arrays.sort(intervals, comparator);

		int left = intervals[0][0];
		int right = intervals[0][1];

		List<int[]> result = new ArrayList<>();

		for(int i=1; i< intervals.length; i++) {
			if(right < intervals[i][0]) {
				// new interval!
				result.add(new int[]{left, right});
				left = intervals[i][0];
				right = intervals[i][1];
			} else if(right == intervals[i][0] || right < intervals[i][1]) {
				// update right
				right = intervals[i][1];
			}
		}

		if(result.size() > 0) {
			int[] last = result.get(result.size() - 1);
			if (last[0] != left && last[1] != right) {
				result.add(new int[]{left, right});
			}
		} else {
			result.add(new int[]{left, right});
		}

		int[][] res = new int[result.size()][2];
		for(int i=0; i< result.size(); i++) {
			res[i] = result.get(i);
		}

		return res;
	}
}
