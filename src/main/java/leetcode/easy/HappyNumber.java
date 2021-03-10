package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	public boolean isHappy(int n) {
		Set<Integer> results = new HashSet<>();

		int current = n, sum;
		while(!results.contains(current)) {
			results.add(current);
			sum = 0;
			while(current > 0) {
				int value = current % 10;
				sum += value * value;
				current = current / 10;
			}

			if(sum == 1) {
				return true;
			}

			current = sum;
		}

		return false;
	}
}
