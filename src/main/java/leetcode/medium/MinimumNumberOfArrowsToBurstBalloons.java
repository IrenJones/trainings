package leetcode.medium;

import org.apache.hadoop.io.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;

public class MinimumNumberOfArrowsToBurstBalloons {
	public static void main(String[] args) {
		int[][] arr = {
				{9,12},
				{1,10},
				{4,11},
				{8,12},
				{3,9},
				{6,9},
				{6,7}
		};
		System.out.println(findMinArrowShots(arr) == 2);
	}

	public static int findMinArrowShots(int[][] points) {
		// sort
		Comparator<int[]> comparator = Comparator.comparingInt((int[] arr) -> arr[1]);
		Arrays.sort(points, comparator);

		int result = 0;
		long end = Long.MIN_VALUE;

		for(int[] entry: points){
			if(entry[0] > end){
				end = entry[1];
				result++;
			}
		}
		return result;
	}
}
