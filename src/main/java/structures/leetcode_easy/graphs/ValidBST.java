package structures.leetcode_easy.graphs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class ValidBST {

	@Setter
	@Getter
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	static class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;
	}

	public static boolean isValidBST(TreeNode root) {
		if(root == null){
			return true;
		}
		return helper(root, null, null);
	}

	private static boolean helper(TreeNode root, Integer left, Integer right) {
		if(root == null){
			return true;
		}
		if( left != null && root.value <= left ||
				right != null && root.value >= right){
			return false;
		}
		return helper(root.left, left, root.value) && helper(root.right, root.value, right);
	}

	public static void main(String[] args) {
		TreeNode root = createTree();
		System.out.println(isValidBST(createTree2()));
		System.out.println(isValidBST(createTree1()));
		System.out.println(checkTree(root));
	}

	private static TreeNode createTree() {
		TreeNode left = new TreeNode(1, null, null);
		TreeNode right = new TreeNode(1, null, null);
		TreeNode root = new TreeNode(2, left, right);
		return root;
	}

	private static TreeNode createTree1() {
		TreeNode t1 = new TreeNode(1, null, null);
		TreeNode root = new TreeNode(1, t1, null);
		return root;
	}

	private static TreeNode createTree2() {
		TreeNode root = new TreeNode(Integer.MAX_VALUE, null, null);
		return root;
	}

	private static boolean checkTree(TreeNode root){
		return checkTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean checkTree(TreeNode root, int lower, int upper) {
		if (root == null) {
			return true;
		}
		if(root.value < lower ||
				root.value > upper){
			return false;
		}
		return checkTree(root.left, lower, root.value) &&
				checkTree(root.right, root.value, upper);
	}
}
