package leetcode.medium;

public class ChampagneTower {

	public static void main(String[] args) {
		System.out.println(champagneTower(100000009, 33, 17));
		System.out.println(champagneTower(2, 1, 1));
	}

	public static double champagneTower(int poured, int query_row, int query_glass) {
		double[][] cups = new double[100][100];
		cups[0][0] = poured;

		double volume;
		for (int i = 0; i < query_row + 1; i++) {
			for (int j = 0; j < i + 1; j++) {
				volume = (cups[i][j] - 1.0) / 2.0;
				if (volume > 0) {
					// split
					cups[i+1][j] += volume;
					cups[i+1][j+1] += volume;
				}
			}
		}

		return Math.min(cups[query_row][query_glass], 1.0);
	}
}
