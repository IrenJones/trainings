package leetcode.leetcode_by_topics.graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {

	public static void main(String[] args) {
		int[][] arr = {{1,2,3},{3,8,4},{5,3,5}};
		System.out.println(minimumEffortPath(arr));
		new PathWithMinimumEffort().minimumEffortPathAgain(arr);
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

	Map<String, Integer> dist;

	// TLE
	public int minimumEffortPathAgain(int[][] heights) {
		dist = new HashMap<>();
		int n = heights.length;
		int m = heights[0].length;

		search(heights, n, m, 0, 0, 0);

		return dist.get((n - 1) + "_" + (m - 1));
	}

	public void search(int[][] h, int n, int m, int i, int j, int cur){
		String s = i + "_" + j;
		if(dist.containsKey(s) && cur >= dist.get(s)){
			return;
		}

		dist.put(s, cur);

		if(i - 1 >= 0 && i - 1 <= n - 1 && j >= 0 && j <= m - 1){
			search(h, n, m, i - 1, j, Math.max(cur, Math.abs(h[i][j] - h[i - 1][j])));
		}
		if(i + 1 >= 0 && i + 1 <= n - 1 && j >= 0 && j <= m - 1){
			search(h, n, m, i + 1, j, Math.max(cur, Math.abs(h[i][j] - h[i + 1][j])));
		}
		if(i >= 0 && i <= n - 1 && j - 1>= 0 && j  - 1<= m - 1){
			search(h, n, m, i, j - 1, Math.max(cur, Math.abs(h[i][j] - h[i][j - 1])));
		}
		if(i >= 0 && i <= n - 1 && j + 1>= 0 && j + 1 <= m - 1){
			search(h, n, m, i, j + 1, Math.max(cur, Math.abs(h[i][j] - h[i][j + 1])));
		}
	}
}
