package leetcode.leetcode_by_topics.graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class VerticalOrderTraversalOfBinaryTree {

	public static void main(String[] args) {
		VerticalOrderTraversalOfBinaryTree r = new VerticalOrderTraversalOfBinaryTree();
		r.verticalTraversal(
				new TreeNode(3,
						new TreeNode(9, null, null),
				new TreeNode(20,
						new TreeNode(15, null, null),
						new TreeNode (7, null, null)))
		);
	}

	Set<Pair<Integer, Pair<Integer, Integer>>> tree = new HashSet<>();
	int maxX = 0;
	int minX = 0;

	public List<List<Integer>> verticalTraversal(TreeNode root) {
		dfs(root, 0, 0);

		List<List<Integer>> lists = new ArrayList<>();
		for(int x = minX; x <= maxX; x++) {

			int finalX = x;
			lists.add(tree.stream().filter(p -> p.getSecond().getFirst() == finalX)
					.sorted(Comparator.<Pair<Integer, Pair<Integer, Integer>>>comparingInt(p -> p.getSecond().getSecond())
							.thenComparingInt(p -> p.getFirst()))
					.map( p -> p.getFirst())
					.collect(Collectors.toList()));
		}

		return lists;
	}

	private void dfs(TreeNode node, int currentX, int currentY) {
		if(node == null) {
			return;
		}

		dfs(node.left, currentX - 1, currentY + 1);
		tree.add(new Pair<>(node.val, new Pair<>(currentX, currentY)));
		dfs(node.right, currentX + 1, currentY + 1);

		maxX = Math.max(currentX, maxX);
		minX = Math.min(currentX, minX);
	}


	private class Pair<T, Y>{
		T first;
		Y second;


		public Pair(T first, Y second) {
			this.first = first;
			this.second = second;
		}

		public T getFirst() {
			return first;
		}

		public Y getSecond() {
			return second;
		}
	}
}
