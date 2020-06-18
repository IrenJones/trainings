package structures.leetcode_easy.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthBT {

	public static void main(String[] args) {
		TreeNode tree = createTree();
		System.out.println(maxDepth(tree));
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

	public static int maxDepth(TreeNode root) {
		int ans = 0;
		if(root == null){
			return ans;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()){
			int size = queue.size();
			for(int i=0;i<size; i++){
				TreeNode node = queue.poll();
				if(node.left != null){
					queue.add(node.left);
				}
				if(node.right != null){
					queue.add(node.right);
				}
			}
			ans++;
		}

		return ans;
	}
}
