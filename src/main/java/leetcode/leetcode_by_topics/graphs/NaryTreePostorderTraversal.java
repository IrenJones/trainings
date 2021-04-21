package leetcode.leetcode_by_topics.graphs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NaryTreePostorderTraversal {

    // iterative
    public List<Integer> postorderIt(Node root) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        Deque<Integer> deq = new LinkedList<>();

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            for (int i = 0; i < node.children.size(); i++) {
                stack.push(node.children.get(i));
            }
            deq.addFirst(node.val);
        }

        res.addAll(deq);

        return res;
    }

    // recursive
    List<Integer> res;

    public List<Integer> postorder(Node root) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        dfs(root);
        return res;
    }

    public void dfs(Node node) {
        for (Node child : node.children) {
            dfs(child);
        }
        res.add(node.val);
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
