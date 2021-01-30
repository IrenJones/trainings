package leetcode.leetcode_by_topics.array.island_problems;

public class IslandPerimeter {

	public int islandPerimeter(int[][] grid) {
		if (grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int perimeter = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					perimeter += 4 - countSurrounded(grid, i, j);
				}
			}
		}
		return perimeter;
	}

	private int countSurrounded(int[][] grid, int i, int j) {
		int count = 0;

		if (i - 1 >= 0 && i - 1 < grid.length && j >= 0 && j < grid[0].length && grid[i - 1][j] == 1) {
			count++;
		}
		if (i + 1 >= 0 && i + 1 < grid.length && j >= 0 && j < grid[0].length && grid[i + 1][j] == 1) {
			count++;
		}
		if (i >= 0 && i < grid.length && j - 1 >= 0 && j - 1 < grid[0].length && grid[i][j - 1] == 1) {
			count++;
		}
		if (i >= 0 && i < grid.length && j + 1 >= 0 && j + 1 < grid[0].length && grid[i][j + 1] == 1) {
			count++;
		}

		return count;
	}
}
