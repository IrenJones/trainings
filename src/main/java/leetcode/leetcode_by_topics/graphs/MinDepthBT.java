package leetcode.leetcode_by_topics.graphs;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class MinDepthBT {

	public static void main(String[] args) {
		TreeNode root = createTree();
		System.out.println(minDepth(root));
		System.out.println(maxDepth(root));
	}

	private static TreeNode createTree() {
		TreeNode t1 = new TreeNode(15, null, null);
		TreeNode t2 = new TreeNode(14, null, t1);
		TreeNode t3 = new TreeNode(12, null, null);
		TreeNode t4 = new TreeNode(13, t3, t2);
		TreeNode t5 = new TreeNode(7, null, null);
		TreeNode t6 = new TreeNode(6, null, t5);
		TreeNode t7 = new TreeNode(4, null, null);
		TreeNode t8 = new TreeNode(5, t7, t6);
		TreeNode t9 = new TreeNode(10, t8, t4);
		return t9;
	}

	public static int minDepth(TreeNode root) {
		if (Objects.isNull(root)) {
			return 0;
		}
		int depth = 1;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			// for each level
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node.left == null && node.right == null) {
					// search shortest height
					return depth;
				}
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			depth++;
		}
		return depth;
	}

	public static int maxDepth(TreeNode root) {
		if (Objects.isNull(root)) {
			return 0;
		}
		int depth = 1;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			// for each level
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if(node.left == null && node.right == null && queue.isEmpty()){
					return depth;
				}
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			depth++;
		}
		return depth;
	}
}
