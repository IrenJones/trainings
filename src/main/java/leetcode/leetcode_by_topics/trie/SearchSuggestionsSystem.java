package leetcode.leetcode_by_topics.trie;

import java.util.ArrayList;
import java.util.List;

public class SearchSuggestionsSystem {

    public static final int LIMIT = 3;

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode();
        for (String product : products) {
            add(root, product);
        }

        List<List<String>> res = new ArrayList<>();

        for (int i = 1; i < searchWord.length() + 1; i++) {
            List<String> cur = new ArrayList<>(LIMIT);
            search(root, searchWord.substring(0, i), cur);
            res.add(cur);
        }

        return res;
    }

    public void search(TrieNode root, String s, List<String> r) {
        TrieNode node = root;
        for(char c: s.toCharArray()){
            if(!node.contains(c)){
                return;
            }
            node = node.get(c);
        }

        search(node, new StringBuilder(s), r);
    }

    public void search(TrieNode node, StringBuilder sb, List<String> r){
        if(r.size() == LIMIT){
            return;
        }

        if(node.isHasEnd()){
            r.add(sb.toString());
        }

        for(char i = 'a'; i <= 'z'; i++){
            if(node.contains(i)){
                sb.append(i);
                search(node.get(i), new StringBuilder(sb), r);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public void add(TrieNode node, String s) {
        TrieNode cur = node;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!cur.contains(c)) {
                cur.put(c, new TrieNode());
            }
            cur = cur.get(c);
        }
        cur.setHasEnd();
    }

    class TrieNode {
        int size = 26;
        TrieNode[] list;
        boolean hasEnd = false;

        public TrieNode() {
            list = new TrieNode[size];
        }

        public TrieNode get(char c) {
            return list[c - 'a'];
        }

        public boolean contains(char c) {
            return list[c - 'a'] != null;
        }

        public void put(char c, TrieNode node) {
            list[c - 'a'] = node;
        }

        public void setHasEnd() {
            hasEnd = true;
        }

        public boolean isHasEnd() {
            return hasEnd;
        }

    }
}
