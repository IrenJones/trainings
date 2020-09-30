package leetcode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.Stack;

public class RangeSumBST {

	public static int sum = 0;

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
		int left = 7;
		int right = 15;
		System.out.println(rangeSumBST(root, left, right));
		System.out.println(rangeSumBSTWithoutRecursion(root, left, right));
	}

	private static TreeNode createTree() {
		TreeNode left = new TreeNode(1, null, null);
		TreeNode right = new TreeNode(1, null, null);
		TreeNode root = new TreeNode(2, left, right);
		return root;
	}

	public static int rangeSumBST(TreeNode root, int L, int R) {
		dfs(root, L,R);
		return sum;
	}

	public static int rangeSumBSTWithoutRecursion(TreeNode root, int L, int R) {
		int result = 0;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode v = stack.pop();
			if(Objects.isNull(v)) {
				if (v.value <= R && v.value >= L) {
					result += v.value;
				}
				if (v.value < R) {
					stack.push(v.right);
				}
				if (v.value > L) {
					stack.push(v.left);
				}
			}
		}
		return result;
	}

	private static void dfs(TreeNode root, int l, int r) {
		if(Objects.isNull(root)){
			return;
		}
		if(root.value >= l && root.value <= r){
			sum += root.value;
		}
		if(l < root.value){
			dfs(root.left, l,r);
		}
		if(root.value < r){
			dfs(root.right, l,r);
		}
	}
}
