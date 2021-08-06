package leetcode.leetcode_by_topics.trie;

import java.util.HashMap;
import java.util.Map;

public class MapSumPairs {

    public static void main(String[] args) {
        MapSumPairs mapSum = new MapSumPairs();
        mapSum.insert("apple", 3);
        mapSum.sum("ap");           // return 3 (apple = 3)
        mapSum.insert("apple", 2);
        mapSum.sum("ap");
    }

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public MapSumPairs() {
        root = new TrieNode(0);
    }

    public void insert(String key, int val) {
        TrieNode cur = root;
        int wordVal = getWordVal(key);
        for (char c : key.toCharArray()) {
            if (!cur.contains(c)) {
                cur.put(c, new TrieNode(val));
            }
            else {
                TrieNode node = cur.get(c);
                node.sum += val - wordVal;
            }
            cur = cur.get(c);
        }
        cur.hasEnd = true;
        cur.wordVal = val;
    }

    private int getWordVal(String key) {
        TrieNode cur = root;

        for (char c : key.toCharArray()) {
            if (!cur.contains(c)) {
                return 0;
            }
            cur = cur.get(c);
        }
        return cur.hasEnd ? cur.wordVal : 0;
    }

    public int sum(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (!cur.contains(c)) {
                return 0;
            }
            cur = cur.get(c);
        }

        return cur.sum;
    }

    class TrieNode {
        boolean hasEnd;
        Map<Character, TrieNode> nodes;
        int sum;
        int wordVal;

        public TrieNode(int sum) {
            nodes = new HashMap<>();
            hasEnd = false;
            this.sum = sum;
            this.wordVal = 0;
        }

        public void put(char c, TrieNode node) {
            nodes.put(c, node);
        }

        public TrieNode get(char c) {
            return nodes.get(c);
        }

        public boolean contains(char c) {
            return nodes.containsKey(c);
        }
    }
}

class MapSum {
    Map<String, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
        ;
    }

    public int sum(String prefix) {
        int sum = 0;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getKey().startsWith(prefix)) {
                sum += e.getValue();
            }
        }
        return sum;
    }
}
