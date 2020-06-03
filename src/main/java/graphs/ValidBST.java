package graphs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.Stack;

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

	public static void main(String[] args) {
		TreeNode root = createTree();
		System.out.println(checkTree(root));
	}

	private static TreeNode createTree() {
		TreeNode left = new TreeNode(1, null, null);
		TreeNode right = new TreeNode(1, null, null);
		TreeNode root = new TreeNode(2, left, right);
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
