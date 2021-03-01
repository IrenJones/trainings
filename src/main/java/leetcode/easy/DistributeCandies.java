package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {

	public int distributeCandies(int[] candyType) {

		Set<Integer> types = new HashSet<>();
		for(int candy: candyType) {
			types.add(candy);
		}

		return Math.min(candyType.length / 2, types.size());
	}
}
