package leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidSquare {
	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		Set<Double> set = new HashSet<>();

		List<int[]> list = Arrays.asList(p1, p2, p3, p4);

		for(int i=0; i < 4; i++) {
			for(int j=0; j< 4; j++) {
				if(i != j) {
					set.add(findLength(list.get(i), list.get(j)));
				}
			}
		}
		return set.size() == 2;
	}

	public double findLength(int[] p1, int[] p2) {
		return Math.sqrt(Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
	}
}
