package graphs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.Stack;

public class DFS {

	@Getter
	@Setter
	@AllArgsConstructor
	static
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
	}

	public static void main(String[] args) {
		TreeNode root = createTree();
		System.out.println(hasValue(root, 14));
		System.out.println(hasValue(root, 13));
		System.out.println(hasValue(root, 1));
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

	private static boolean hasValue(TreeNode root, int value){
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			if(!Objects.isNull(node)){
				if(node.val == value){
					return true;
				}
				if(node.val < value){
					stack.push(node.right);
				}
				if(node.val > value){
					stack.push(node.left);
				}
			}
		}
		return false;
	}
}
