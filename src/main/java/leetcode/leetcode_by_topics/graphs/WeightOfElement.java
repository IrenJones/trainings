package leetcode.leetcode_by_topics.graphs;

import java.util.ArrayList;
import java.util.List;

/*
*   Given an Binary Tree
      1
     /\
    2  3
   /\  / \
  4  5 6  7

find weight of a particular element such that
weight = sum of(product of all the traversal path through that node)

for ex consider 2
find all path traversing through 2
{1,2,4} and {1,2,5}
now weight of 2 is = (1*2*4) +(1*2*5)  = 8 + 10 = 18

weight(3) = (1*3*6) + (1*3*7) =  18 + 21 = 39
* */
public class WeightOfElement {

	public static int getWeight(TreeNode target, TreeNode root){
		List<List<TreeNode>> lists = new ArrayList<>();
		getWay(root, new ArrayList<>(), lists);
		System.out.println(lists);

		int resultMain = 0;

		for(List<TreeNode> list: lists){
			int result = 1;
			boolean included = false;
			for(TreeNode value: list) {
				if(value == target) {
					included = true;
				}
				result *= value.val;
			}
			if(included) {
				resultMain += result;
			}
		}

		return resultMain;
	}

	public static void getWay(TreeNode root, List<TreeNode> list, List<List<TreeNode>> res) {
		if(root == null) {
			return;
		}

		list.add(root);

		if(root.left == null && root.right == null){
			res.add(list);
			return;
		}

		getWay(root.left, new ArrayList<>(list), res);
		getWay(root.right, new ArrayList<>(list), res);
	}


	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		System.out.println(getWeight(root, root));
		System.out.println(getWeight(root.left, root));
		System.out.println(getWeight(root.left.right, root));
	}
}
