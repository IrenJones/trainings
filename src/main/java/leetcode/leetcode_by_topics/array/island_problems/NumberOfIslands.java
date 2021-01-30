package leetcode.leetcode_by_topics.array.island_problems;

public class NumberOfIslands {

	public static void main(String[] args) {
	}

	public static int numIslands(char[][] grid) {
		if(grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int count = 0;
		for(int i=0; i< grid.length; i++) {
			for(int j=0; j< grid[0].length; j++) {
				if(grid[i][j] == '1') {
					detectIsland(grid, i, j);
					count++;
				}
			}
		}
		return count;
	}

	private static void detectIsland(char[][] grid, int i, int j) {
		if(i < 0 || i> grid.length - 1 || j < 0 || j > grid[0].length - 1) {
			return;
		}

		if(grid[i][j] == '0'){
			return;
		}
		grid[i][j] = '0';

		detectIsland(grid, i + 1, j);
		detectIsland(grid, i - 1, j);
		detectIsland(grid, i, j + 1);
		detectIsland(grid, i, j - 1);
	}
}
