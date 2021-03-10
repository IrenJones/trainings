package leetcode.leetcode_by_topics.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowToTree {

	public TreeNode addOneRow(TreeNode root, int v, int d) {
		if (d == 1) {
			return new TreeNode(v, root, null);
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int level = 1;
		while (level < d - 1) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			level++;
		}

		TreeNode tmp;
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			tmp = node.left;
			node.left = new TreeNode(v, tmp, null);

			tmp = node.right;
			node.right = new TreeNode(v, null, tmp);
		}

		return root;
	}
}
