package leetcode.leetcode_by_topics.array.path;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

	public static void main(String[] args) {
		ShortestPathInBinaryMatrix solution = new ShortestPathInBinaryMatrix();
		int[][] arr = {
				{0, 0, 0},
				{1, 1, 0},
				{1, 1, 0}
		};
		solution.shortestPathBinaryMatrix(arr);
	}

	private int dir[][] = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, -1}, {-1, 1}, {-1, -1}, {1, 1}};

	public int shortestPathBinaryMatrix(int[][] grid) {

		if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) {
			return -1;
		}

		boolean[][] visited = new boolean[grid.length][grid[0].length];
		visited[0][0] = true;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{0, 0});

		int pathLen = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] point = queue.remove();

				// check the end
				if (point[0] == grid.length - 1 && point[1] == grid[0].length - 1) {
					return pathLen + 1;
				}

				for (int k = 0; k < 8; k++) {
					int nextX = dir[k][0] + point[0];
					int nextY = dir[k][1] + point[1];

					if (nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length && !visited[nextX][nextY] && grid[nextX][nextY] == 0) {
						queue.add(new int[]{nextX, nextY});
						visited[nextX][nextY] = true;
					}

				}
			}
			pathLen++;
		}

		return -1;
	}
}
