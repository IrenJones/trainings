package leetcode.leetcode_by_topics.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrderTraversal {
    public static void main(String[] args) {
        List<List<Integer>> list = new BTLevelOrderTraversal().levelOrder(createTree());
        list.forEach(v -> {
            v.forEach(vv -> System.out.print(vv + " "));
            System.out.println();
        });
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> list;
        while (!q.isEmpty()) {
            list = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                list.add(node.val);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            res.add(list);
        }

        return res;
    }
}
