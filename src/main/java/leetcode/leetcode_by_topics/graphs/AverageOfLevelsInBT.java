package leetcode.leetcode_by_topics.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBT {
	public List<Double> averageOfLevels(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		List<Double> result = new ArrayList<>();
		Queue<TreeNode> nodes = new LinkedList<>();

		nodes.add(root);
		while (!nodes.isEmpty()) {
			int size = nodes.size();
			double sum = 0;
			for (int i = 0; i < size; i++) {
				TreeNode cur = nodes.poll();
				sum += cur.val;

				if (cur.left != null) {
					nodes.add(cur.left);
				}

				if (cur.right != null) {
					nodes.add(cur.right);
				}
			}
			result.add(sum / size);
		}
		return result;
	}
}
