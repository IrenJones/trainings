package leetcode.leetcode_by_topics.graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {

	public static void main(String[] args) {
		int[][] arr = {{1,2,3},{3,8,4},{5,3,5}};
		System.out.println(minimumEffortPath(arr));
	}

	public static int minimumEffortPath(int[][] heights) {
		int[] dir = {0, 1, 0, -1, 0};

		int n = heights.length, m = heights[0].length;

		int[][] paths = new int[n][m];

		// set all path as max value
		for(int[] arr: paths) {
			Arrays.fill(arr, Integer.MAX_VALUE);
		}

		// set the init node as 0
		int x = 0, y = 0, path = 0;
		paths[0][0] = path;

		PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[2]));
		queue.offer(new int[]{x,y, path});

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			x = current[0];
			y = current[1];
			path = current[2];

			// check if reach the end
			if(x == n - 1 && y == m - 1) {
				return path;
			}

			for(int direction = 0; direction < 4; direction++) {
				int nextX = x + dir[direction];
				int nextY = y + dir[direction + 1];

				// work only in area
				if(nextX > n - 1 || nextX < 0 || nextY > m - 1 || nextY < 0 || nextX == 0 && nextY == 0) {
					continue;
				} else {

					// determine if we have new height on our path
					int nextPathCost = Math.max(path, Math.abs(heights[nextX][nextY] - heights[x][y]));

					// if we found unvisited node - set the path cost and add to the queue of all nodes
					// or if our new path to current node requires less diffs
					if (paths[nextX][nextY] > nextPathCost) {
						paths[nextX][nextY] = nextPathCost;
						queue.offer(new int[]{nextX, nextY, nextPathCost});
					}
				}
			}
		}
		return -1;
	}
}
