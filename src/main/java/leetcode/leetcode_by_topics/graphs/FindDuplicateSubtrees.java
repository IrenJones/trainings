package leetcode.leetcode_by_topics.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {

    Map<String, Integer> freq;
    Map<String, TreeNode> map;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        freq = new HashMap<>();
        map = new HashMap<>();

        tree2str(root);

        for(Map.Entry<String, Integer> e: freq.entrySet()){
            if(e.getValue() > 1){
                res.add(map.get(e.getKey()));
            }
        }
        return res;
    }

    public StringBuilder tree2str(TreeNode node) {
        if(node == null){
            return new StringBuilder();
        }

        StringBuilder res = new StringBuilder();
        res.append(node.val);

        if(node.left == null && node.right == null){
            saveToMap(res.toString(), node);
            return res;
        }

        res.append("(")
                .append(tree2str(node.left))
                .append(")");

        StringBuilder right = tree2str(node.right);

        if(right.length() > 0){
            res.append("(")
                    .append(right)
                    .append(")");
        }

        saveToMap(res.toString(), node);

        return res;
    }

    public void saveToMap(String s, TreeNode node){
        freq.put(s, freq.getOrDefault(s, 0) + 1);
        map.put(s, node);
    }


    // --- one map only

//    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
//        List<TreeNode> res = new ArrayList<>();
//        if(root == null){
//            return res;
//        }
//
//        Map<String, Integer> freq = new HashMap<>();
//
//        tree2str(root, freq, res);
//
//        return res;
//    }
//
//    public StringBuilder tree2str(TreeNode node, Map<String, Integer> freq, List<TreeNode> resList) {
//        if(node == null){
//            return new StringBuilder();
//        }
//
//        StringBuilder res = new StringBuilder();
//        res.append(node.val);
//
//        if(node.left == null && node.right == null){
//            String s = res.toString();
//            freq.put(s, freq.getOrDefault(s, 0) + 1);
//            if(freq.get(s) == 2){
//                resList.add(node);
//            }
//            return res;
//        }
//
//        res.append("(")
//                .append(tree2str(node.left, freq, resList))
//                .append(")");
//
//        StringBuilder right = tree2str(node.right, freq, resList);
//
//        if(right.length() > 0){
//            res.append("(")
//                    .append(right)
//                    .append(")");
//        }
//
//        String s = res.toString();
//        freq.put(s, freq.getOrDefault(s, 0) + 1);
//        if(freq.get(s) == 2){
//            resList.add(node);
//        }
//
//        return res;
//    }
}
