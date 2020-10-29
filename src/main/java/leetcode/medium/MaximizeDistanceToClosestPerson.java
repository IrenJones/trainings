package leetcode.medium;

public class MaximizeDistanceToClosestPerson {

	public static void main(String[] args) {
		System.out.println(maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1, 0}) == 2);
	}

	public static int maxDistToClosest(int[] seats) {
		int maxDist = 0;
		int left = -1, i = 0;

		while (i < seats.length) {
			if(seats[i] == 1) {
				maxDist = left == -1
						? i
						: Math.max(maxDist, (i - left)/2);
				left = i;
			} else if(i == seats.length - 1 && seats[i] == 0) {
				maxDist = Math.max(maxDist, seats.length - 1 - left);
			}
			i++;
		}
		return maxDist;
	}
}
