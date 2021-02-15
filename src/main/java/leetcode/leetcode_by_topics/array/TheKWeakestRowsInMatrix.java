package leetcode.leetcode_by_topics.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TheKWeakestRowsInMatrix {

	public int[] kWeakestRows(int[][] mat, int k) {
		PriorityQueue<Pair> q = new PriorityQueue<>(
				Comparator.<Pair>comparingInt(pair -> pair.power)
						.thenComparingInt(p -> p.rowNumber));

		for(int i = 0; i< mat.length; i++) {
			q.add(new Pair(Arrays.stream(mat[i]).sum(), i));
		}

		int[] result = new int[k];
		for(int i=0; i< k; i++) {
			result[i] = q.poll().rowNumber;
		}
		return result;
	}

	class Pair{
		Integer power;
		Integer rowNumber;

		public Pair(Integer power, Integer rowNumber) {
			this.power = power;
			this.rowNumber = rowNumber;
		}
	}
}
