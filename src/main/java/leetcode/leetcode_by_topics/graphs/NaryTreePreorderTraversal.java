package leetcode.leetcode_by_topics.graphs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class NaryTreePreorderTraversal {

    // iterative
    public List<Integer> preorderIt(Node root) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<Node> deq = new LinkedList<>();
        deq.add(root);
        while(!deq.isEmpty()){
            Node node = deq.pollFirst();
            res.add(node.val);
            for(int i = node.children.size() - 1; i >= 0; i--){
                deq.addFirst(node.children.get(i));
            }
        }
        return res;
    }

    // recursive
    List<Integer> res = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        dfs(root);
        return res;
    }

    public void dfs(Node node) {
        res.add(node.val);
        for (Node child : node.children) {
            dfs(child);
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = new ArrayList<>(children);
        }
    }
}
