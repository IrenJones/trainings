package leetcode.medium;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;
import java.util.Comparator;
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
}
