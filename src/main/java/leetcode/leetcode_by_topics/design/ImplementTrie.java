package leetcode.leetcode_by_topics.design;

public class ImplementTrie {
}

class Trie {

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word != null && word.length() > 0) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!node.contains(c)) {
                    node.put(c, new TrieNode());
                }
                node = node.get(c);
            }
            node.setEnd();
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    private TrieNode searchPrefix(String word) {
        if (word != null && word.length() > 0) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!node.contains(c)) {
                    return null;
                }
                node = node.get(c);
            }
            return node;
        }
        return null;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    class TrieNode {
        int size = 26;
        TrieNode[] links;
        boolean isEnd;

        public TrieNode() {
            links = new TrieNode[size];
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

        public void put(char c, TrieNode node) {
            links[c - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }
}
