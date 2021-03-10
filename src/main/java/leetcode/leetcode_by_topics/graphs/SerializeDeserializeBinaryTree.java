package leetcode.leetcode_by_topics.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {

	public static void main(String[] args) {
		SerializeDeserializeBinaryTree solution = new SerializeDeserializeBinaryTree();
		System.out.println(solution.serialize(new TreeNode(1,
				new TreeNode(2, null, null),
				new TreeNode(3, null,
						new TreeNode(4, null, null)))));

		solution.deserialize("1,2,3,null,null,null,4,null,null");
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if(root == null) {
			return "";
		}

		StringBuilder result = new StringBuilder();
		Queue<TreeNode> nodes = new LinkedList<>();
		TreeNode defaultNull = new TreeNode(1001, null, null);
		nodes.add(root);
		while (!nodes.isEmpty()){
			int size = nodes.size();
			for(int i = 0; i < size; i++) {
				TreeNode node = nodes.poll();
				if(node == defaultNull) {
					result.append("null").append(",");
				} else {
					result.append(node.val).append(",");
					if(node.left == null) {
						nodes.add(defaultNull);
					} else {
						nodes.add(node.left);
					}
					if(node.right == null) {
						nodes.add(defaultNull);
					} else {
						nodes.add(node.right);
					}
				}
			}
		}

		result.deleteCharAt(result.length() - 1);

		return result.toString();
	}


	/* Let's split this task into two tasks */

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if(data.length() == 0) {
			return null;
		}

		int index = 1;
		String[] datas = data.split(",");
		TreeNode root = new TreeNode(Integer.parseInt(datas[0]), null, null);
		Queue<TreeNode> nodes = new LinkedList<>();
		nodes.add(root);
		while (!nodes.isEmpty()){
			int size = nodes.size() * 2;
			for (int i = index; i < index + size; i = i + 2) {
				TreeNode left = null;
				if(!datas[i].equals("null")) {
					left = new TreeNode(Integer.parseInt(datas[i]), null, null);
					nodes.add(left);
				}
				TreeNode right = null;
				if(!datas[i + 1].equals("null")) {
					right = new TreeNode(Integer.parseInt(datas[i + 1]), null, null);
					nodes.add(right);
				}
				TreeNode node = nodes.poll();
				node.left = left;
				node.right = right;
			}
			index = index + size;
		}
		return root;
	}
}
