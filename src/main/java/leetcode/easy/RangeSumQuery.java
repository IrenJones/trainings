package leetcode.easy;

import org.apache.commons.math3.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class RangeSumQuery {

	public static void main(String[] args) {
		NumArrayyy a = new NumArrayyy(new int[]{-2, 0, 3, -5, 2, -1});
		System.out.println(a.sumRange(2,5));
	}
}

class NumArrayy {

	private Map<Pair< Integer, Integer>, Integer> map = new HashMap<>();

	public NumArrayy(int[] nums) {
		for(int i=0; i< nums.length; i++){
			int sum =0;
			for(int j=i; j<nums.length; j++){
				sum+= nums[i];
				map.put(Pair.create(i, j), sum);
			}
		}
	}

	public int sumRange(int i, int j) {
		return map.get(Pair.create(i,j));
	}
}

class NumArrayyy {

	private int[] sums;
	public NumArrayyy(int[] nums) {
		sums = new int[nums.length+1];
		for(int i=0; i< nums.length; i++){
			sums[i+1] = sums[i] + nums[i];
		}
	}

	public int sumRange(int i, int j) {
		return sums[j+1] - sums[i];
	}
}
