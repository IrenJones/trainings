package leetcode.leetcode_by_topics.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlipBTtoMatchPreorderTraversal {

    public static void main(String[] args) {
        FlipBTtoMatchPreorderTraversal s = new FlipBTtoMatchPreorderTraversal();
//        s.flipMatchVoyage(new TreeNode(1, new TreeNode(2, null, null), null),
//            new int[]{2, 1});


        s.flipMatchVoyage(new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null)),
            new int[]{1, 3, 2});
    }

    List<Integer> res = new ArrayList<>();
    int index = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {

        res = new ArrayList<>();
        if(voyage.length > 1) {
            if(!dfs(root, voyage)) {
                return Arrays.asList(-1);
            }
        }

        return res;
    }

    public boolean dfs(TreeNode node, int[] arr) {
        if (node == null) {
            return true;
        }

        if (node.val != arr[index]) {
            index = index + 1;
            return false;
        }

        index = index + 1;
        if (node.left != null && node.left.val != arr[index]) {
            res.add(node.val);
            return dfs(node.right, arr) && dfs(node.left, arr);
        } else {
            return dfs(node.left, arr) && dfs(node.right, arr);
        }
    }
}
