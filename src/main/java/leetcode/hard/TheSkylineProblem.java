package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TheSkylineProblem {

	static boolean toUp = true;

	public static void main(String[] args) {
		int[][] arr = {
				{2, 9, 10},
				{3, 7, 15},
				{5, 12, 12},
				{15, 20, 10},
				{19, 24, 8}
		};

		getSkyline(arr);
	}

	public static List<List<Integer>> getSkyline(int[][] buildings) {
		List<List<Integer>> result = new ArrayList<>();

		if(buildings.length == 0){
			return result;
		}

		int maxHeight = 0;
		int maxLength = 0;
		int start = Integer.MAX_VALUE;
		for(int i=0; i< buildings.length; i++) {
			maxHeight = Math.max(maxHeight, buildings[i][2]);
			maxLength = Math.max(maxLength, buildings[i][1]);
			start = Math.min(start, buildings[i][0]);
		}

		if(maxHeight == 0 || maxLength == 0){
			return result;
		}

		boolean[][] grid = new boolean[maxLength + 1][maxHeight + 1];

		for(int i=0; i< buildings.length; i++) {
			addToGrid(grid, buildings[i]);
		}

		// go through grid and finding points when change to horizontal
		int[][] direction = new int[3][2];
		direction[0] = new int[]{0, 1};
		direction[1] = new int[]{1, 0};
		direction[2] = new int[]{0, -1};

		int i = start;
		int j = 0;
		int currentDir = 0;
		int prevDir;
		while(i <= maxLength) {
			while (checkAround(grid, direction, currentDir, i, j, maxLength, maxHeight)) {
				i += direction[currentDir][0];
				j += direction[currentDir][1];
			}
			if(currentDir == 0) {
				prevDir = currentDir;
				currentDir = 1;
			} else if (currentDir == 1){
				prevDir = currentDir;
				currentDir = toUp ? 0 : 2;
			} else {
				prevDir = 2;
				currentDir = 1;
			}

			if(i == maxLength - 1) {
				break;
			}

			if(currentDir == 1) {
				if(prevDir != 2) {
					result.add(Arrays.asList(i, j + 1));
				} else {
					if(j != 0) {
						result.add(Arrays.asList(i + 1, j + 1));
					} else {
						result.add(Arrays.asList(i + 1, j));
					}
					i++;
				}
			}
		}
		result.add(Arrays.asList(maxLength, 0));

		return result;
	}

	private static boolean checkAround(boolean [][] grid, int [][] direction, int currentDir, int i, int j,
									   int maxLength, int maxHeight) {
		boolean result = false;
		switch (currentDir) {
			case 0: {
				result = j < maxHeight &&
						grid[i + direction[currentDir][0]][j + direction[currentDir][1]] == true;
				break;
			}
			case 1: {
				toUp = j < maxHeight && grid[i][j + 1] == true;
				result = !toUp
						&& i < maxLength && grid[i + direction[currentDir][0]][j + direction[currentDir][1]] == true
						|| j == 0 && grid[i + direction[currentDir][0]][j + direction[currentDir][1]] == false;
				break;
			}
			case 2: {
				result = i < maxLength && j > 0
						&& grid[i + direction[currentDir][0]][j + direction[currentDir][1]] == true
						&& grid[i + 1][j] == false;
			}
		}
		return result;
	}

	private static void addToGrid(boolean[][] grid, int[] coordinates) {
		for(int i=0; i < coordinates[2]; i++) {
			for(int j=coordinates[0]; j < coordinates[1]; j++) {
				grid[j][i] = true;
			}
		}
	}
}
