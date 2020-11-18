package leetcode.leetcode_by_topics.array.island_problems;

public class MaxAreaOfIsland {
	public int maxAreaOfIsland(int[][] grid) {
		if (grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int result = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					result = Math.max(result, getSizeOfIsland(grid, i, j));
				}
			}
		}
		return result;
	}

	public int getSizeOfIsland(int[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
			return 0;
		}

		if (grid[i][j] == 0) {
			return 0;
		}

		int sum = 1;
		grid[i][j] = 0;
		sum += getSizeOfIsland(grid, i - 1, j);
		sum += getSizeOfIsland(grid, i + 1, j);
		sum += getSizeOfIsland(grid, i, j + 1);
		sum += getSizeOfIsland(grid, i, j - 1);

		return sum;
	}
}
