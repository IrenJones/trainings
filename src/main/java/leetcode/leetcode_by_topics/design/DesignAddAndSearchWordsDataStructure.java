package leetcode.leetcode_by_topics.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DesignAddAndSearchWordsDataStructure {
}

class WordDictionary {

    Set<String> set;
    Map<Integer, List<String>> map;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        set = new HashSet<>();
        map = new HashMap<>();
    }

    public void addWord(String word) {
        if (word != null && word.length() > 0 && !set.contains(word)) {
            set.add(word);
            List<String> words = map.getOrDefault(word.length(), new ArrayList<>());
            words.add(word);
            map.put(word.length(), words);
        }
    }

    public boolean search(String word) {
        if (set.contains(word)) {
            return true;
        }

        int size = word.length();
        if (map.containsKey(size)) {
            List<String> possibleWords = map.get(size);
            for (String s : possibleWords) {
                if (check(s, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean check(String s1, String pattern) {
        for (int i = 0; i < s1.length(); i++) {
            if (pattern.charAt(i) == '.' || s1.charAt(i) == pattern.charAt(i)) {
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }
}

class WordDictionaryTrie {

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionaryTrie() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        if (word != null && word.length() > 0) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!node.contains(c)) {
                    node.put(new TrieNode(), c);
                }
                node = node.get(c);
            }
            node.setHasWord();
        }
    }

    public boolean search(String word) {
        if (word != null && word.length() > 0) {
            return searchPrefix(word, 0, root);
        }
        return false;
    }

    private boolean searchPrefix(String word, int i, TrieNode node) {
        if (i == word.length()) {
            return node.isHasWord();
        }
        char c = word.charAt(i);
        if (c != '.') {
            if (!node.contains(c)) {
                return false;
            }
            return searchPrefix(word, i + 1, node.get(c));
        }
        else {
            boolean res = false;
            for (TrieNode n : node.getAll()) {
                if (n != null) {
                    res = res || searchPrefix(word, i + 1, n);
                }
            }
            return res;
        }
    }

    class TrieNode {
        int size = 26;
        TrieNode[] links;
        boolean hasWord;

        public TrieNode() {
            links = new TrieNode[26];
        }

        public boolean contains(char c) {
            return links[c - 'a'] != null;
        }

        public TrieNode get(char c) {
            if (contains(c)) {
                return links[c - 'a'];
            }
            return null;
        }

        public void put(TrieNode node, char c) {
            if (!contains(c)) {
                links[c - 'a'] = node;
            }
        }

        public void setHasWord() {
            hasWord = true;
        }

        public boolean isHasWord() {
            return hasWord;
        }

        public TrieNode[] getAll() {
            return links;
        }
    }
}
