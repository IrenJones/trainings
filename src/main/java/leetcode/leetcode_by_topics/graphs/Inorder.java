package leetcode.leetcode_by_topics.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Inorder {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        helper(root, res);

        return res;
    }

    public void helper(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }

        helper(node.left, list);
        list.add(node.val);
        helper(node.right, list);
    }

    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if(root == null){
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }

        return res;
    }
}
