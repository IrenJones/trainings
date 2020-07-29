package structures.leetcode_easy.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BTLevelOrderTraversal {
	public static void main(String[] args) {
		List<List<Integer>> list = new BTLevelOrderTraversal().levelOrder(createTree());
		list.forEach(v -> {
			v.forEach(vv -> System.out.print(vv + " "));
			System.out.println();
		});
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

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		int countOnLevel = 0;
		if(root != null){
			queue.add(root);
			countOnLevel++;
		}
		while (!queue.isEmpty()){
			List<Integer> list = new ArrayList<>();
			while(countOnLevel > 0) {
				TreeNode node = queue.poll();
				list.add(node.val);
				countOnLevel--;
				if(node.left != null){
					queue.add(node.left);
				}
				if(node.right != null){
					queue.add(node.right);
				}
			}
			result.add(list);
			countOnLevel = queue.size();
		}
		return result;
	}
}
