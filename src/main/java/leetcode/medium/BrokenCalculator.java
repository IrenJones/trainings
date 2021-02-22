package leetcode.medium;

import java.util.PriorityQueue;

public class BrokenCalculator {

	public static void main(String[] args) {
		BrokenCalculator bk = new BrokenCalculator();
		bk.brokenCalc(2, 3);
	}

	/*
		2 options:
		1) if y is even -> y / 2
		2) y is odd -> y + 1

		Need to prove this approach is optimal.
		Suppose next: we can do 2 +1 operations and one /2. (y + 1 + 1) / 2 = y / 2 + 1
		We see: from one side we can do 3 operations. From another side - only two.
		Let's go a bit deeper.
		Suppose that we do 2N +1 operations and only 1 /2. So: (y + 2N)/2 = y/ 2 + N.
		See? We can do 2N + 1 operation and get the same result when we firstly divide and after do N +1 operations
		(N + 1 totally).

		So, it's optimal to /2 when it's possible (when y is even ofk).
		So, time complexity will be O(log Y) - we divide our number by 2 when it's possible. So it gives us log.
	 */

	public int brokenCalc(int x, int y) {
		int count = 0;

		while(y > x) {
			y = (y % 2 == 0)
					? y / 2
					: y + 1;
			count++;
		}

		return count + x - y;
	}
}
