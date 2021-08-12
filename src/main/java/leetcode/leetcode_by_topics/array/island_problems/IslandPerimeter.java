package leetcode.leetcode_by_topics.array.island_problems;

public class IslandPerimeter {

	public static void main(String[] args) {
		IslandPerimeter s = new IslandPerimeter();
		int[][] grid = {
			{0, 1, 0, 0},
			{1, 1, 1, 0},
			{0, 1, 0, 0},
			{1, 1, 0, 0}
		};
		s.islandPerimeterAgain(grid);
	}

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


	public int islandPerimeterAgain(int[][] grid) {
		int perimeter = 0;

		int n = grid.length;
		int m = grid[0].length;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				if(grid[i][j] == 1){
					perimeter += 4;
					if(i > 0 && grid[i - 1][j] == 1){
						perimeter -= 2;
					}
					if(j > 0 && grid[i][j - 1] == 1){
						perimeter -=2;
					}
				}
			}
		}

		return perimeter;
	}
}
