package leetcode.leetcode_by_topics.array.island_problems;

public class LargestConnectedComponentOnGrid {

	public static void main(String[] args) {
		int[][] grid = {
				{1, 1, 0, 0},
				{0, 1, 1, 0},
				{0, 0, 1, 0},
				{1, 0, 0, 0}
		};

		maxConnectedComponent(grid);
	}

	public static int maxConnectedComponent(int[][] grid) {
		if(grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int maxRegionSize = 0;

		for(int i=0; i< grid.length; i++) {
			for(int j=0; j< grid[0].length; j++) {
				int size = getRegionSize(grid, i, j);
				maxRegionSize = Math.max(size, maxRegionSize);
			}
		}

		return maxRegionSize;
	}

	private static int getRegionSize(int[][] grid, int i, int j) {

		if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
			return 0;
		}

		if(grid[i][j] == 0) {
			return 0;
		}

		int result = 1;
		grid[i][j] = 0;

		for(int row = i - 1; row <= i + 1; row++) {
			for(int col = j - 1; col <= j + 1; col++) {
				if(!(row == i && col == j)) {
					result += getRegionSize(grid, row, col);
				}
			}
		}

		return result;
	}
}
