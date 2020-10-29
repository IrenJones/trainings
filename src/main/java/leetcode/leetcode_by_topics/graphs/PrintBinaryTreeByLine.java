package leetcode.leetcode_by_topics.graphs;

import java.util.LinkedList;
import java.util.Queue;

// Given an binary Tree Print the Tree Line by line
//
//		 1
//		/ \
//	   0   3
//	   /\
//	  4  5

//		output ::
//		1
//		03
//		45

public class PrintBinaryTreeByLine {
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		printTreeLineByLine(root);
	}

	public static void printTreeLineByLine(TreeNode root){

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		TreeNode current;
		int size = 0;
		while(!queue.isEmpty()) {
			size = queue.size();
			StringBuilder sb = new StringBuilder();
			for(int i=0; i< size; i++) {
				current = queue.poll();
				if(current.left != null) {
					queue.add(current.left);
				}
				if(current.right != null) {
					queue.add(current.right);
				}
				sb.append(current.val);
			}
			System.out.println(sb.toString());
		}
	}
}
