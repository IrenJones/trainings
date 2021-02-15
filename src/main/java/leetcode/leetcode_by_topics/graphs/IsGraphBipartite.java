package leetcode.leetcode_by_topics.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {

	public static void main(String[] args) {
		IsGraphBipartite solution = new IsGraphBipartite();
		int[][] arr = {{1,3},{0,2},{1,3},{0,2}};
		solution.isBipartite(arr);
	}

	public boolean isBipartite(int[][] graph) {
		int[] colors = new int[graph.length];

		for(int i=0; i< graph.length; i++) {
			if(colors[i] == 0){
				Queue<Integer> queue = new LinkedList<>();
				queue.add(i);
				colors[i] = 1;

				while (!queue.isEmpty()) {
					Integer current = queue.poll();
					for(int v: graph[current]) {
						if(colors[v] == 0) {
							colors[v] = -colors[current];
							queue.add(v);
						} else if(colors[v] != -colors[current]) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	public boolean isBipartiteDFS(int[][] graph) {
		int[] colors = new int[graph.length];

		for(int i=0; i< graph.length; i++) {
			// check only unvisited (where color is not set)
			if(colors[i] == 0 && !isValidColor(colors, i, 1, graph)){
				return false;
			}
		}
		return true;
	}

	private boolean isValidColor(int[] colors, int i, int color, int[][] graph) {
		if(colors[i] == 0) {
			colors[i] = color;
			for(int v: graph[i]) {
				if (!isValidColor(colors, v, -color, graph)) {
					return false;
				}
			}
			return true;
		}
		return colors[i] == color;
	}
}
