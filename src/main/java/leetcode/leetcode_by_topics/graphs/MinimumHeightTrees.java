package leetcode.leetcode_by_topics.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class MinimumHeightTrees {

	public static void main(String[] args) {
//		int [][] arr = {
//				{1,0},
//				{1,2},
//				{1,3},
//		};

		int[][] arr = {
				{3,0},
				{3,1},
				{3,2},
				{3,4},
				{5,4}
		};
		findMinHeightTrees(6, arr);
	}

	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<List<Integer>> graph = new ArrayList<>();
		List<Integer> result = new ArrayList<>();

		if(n < 2) {
			return Collections.singletonList(0);
		}

		int[] degrees = new int[n];
		for(int i=0; i< n; i++) {
			graph.add(new ArrayList<>());
		}

		for(int i=0; i< edges.length; i++) {
			List<Integer> l1 = graph.get(edges[i][0]);
			l1.add(edges[i][1]);
			l1 = graph.get(edges[i][1]);
			l1.add(edges[i][0]);
			degrees[edges[i][0]]++;
			degrees[edges[i][1]]++;
		}

		Queue<Integer> queue = new LinkedList<>();

		for(int i=0; i< n; i++) {
			if(degrees[i] == 1) {
				queue.add(i);
			}
		}

		while(!queue.isEmpty()) {
			result= new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int current = queue.poll();
				result.add(current);
				for (int connected : graph.get(current)) {
					degrees[connected]--;
					// connected node became leaf node
					if (degrees[connected] == 1) {
						queue.add(connected);
					}
				}
			}
		}
		return result;
	}

	// time limit :(
	public static List<Integer> findMinHeightTreesMy(int n, int[][] edges) {
		Map<Integer, Node> map = new HashMap<>();

		if(n < 2) {
			return Collections.singletonList(0);
		}

		for(int i=0; i< edges.length; i++) {
			Node n1;
			List<Node> neb1;
			if(map.containsKey(edges[i][0])) {
				n1 = map.get(edges[i][0]);
				neb1 = n1.neighbors;
			} else {
				n1 = new Node(edges[i][0]);
				neb1 = new ArrayList<>();
				n1.neighbors = neb1;
				map.put(edges[i][0], n1);
			}

			Node n2;
			List<Node> neb2;
			if(map.containsKey(edges[i][1])) {
				n2 = map.get(edges[i][1]);
				neb2 = n2.neighbors;
			} else {
				n2 = new Node(edges[i][1]);
				neb2 = new ArrayList<>();
				n2.neighbors = neb2;
				map.put(edges[i][1], n2);
			}
			neb1.add(n2);
			neb2.add(n1);
		}

		Map<Integer, Integer> results  = new HashMap<>();
		int minResult = Integer.MAX_VALUE;

		for(Map.Entry<Integer, Node> e: map.entrySet()) {
			int h = bfs(e.getValue(), e.getValue());
			minResult = Math.min(minResult, h);
			results.put(e.getValue().val, h);
		}

		int finalMinResult = minResult;
		return results.entrySet().stream()
				.filter(e -> e.getValue() == finalMinResult)
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
	}

	private static int bfs(Node root, Node prev) {
		if(root == null) {
			return 0;
		}
		if (root.neighbors == null || root.neighbors.size() == 0) {
			return 1;
		}

		int max = 0;
		List<Node> neb = new ArrayList<>(root.neighbors);
		neb.remove(prev);
		for (int i = 0; i < neb.size(); i++) {
			max = Math.max(bfs(neb.get(i), root), max);
		}
		return 1 + max;
	}
}
