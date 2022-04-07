package leetcode.leetcode_by_topics.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Preorder {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode node, List<Integer> list){
        if (node == null){
            return;
        }

        list.add(node.val);
        helper(node.left, list);
        helper(node.right, list);
    }



    public List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if(root == null){
            return res;
        }

        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);
        while(!nodes.isEmpty()){
            TreeNode node = nodes.pop();
            res.add(node.val);

            if(node.right != null){
                nodes.push(node.right);
            }

            if(node.left != null){
                nodes.push(node.left);
            }
        }

        return res;
    }
}
