package leetcode.leetcode_by_topics.trie;

import java.util.Arrays;
import java.util.List;

public class ReplaceWords {

    public static void main(String[] args) {
        ReplaceWords s = new ReplaceWords();
        s.replaceWords(Arrays.asList("cat","bat","rat"), "the cattle was rattled by the battery");
    }

//    TrieNode root;
//
//    public String replaceWords(List<String> dictionary, String sentence) {
//        // init
//        root = new TrieNode();
//
//        // add to dict
//        for(String word : dictionary){
//            if(word != null){
//                add(word);
//            }
//        }
//
//        // replace
//        String[] words = sentence.split(" ");
//        StringBuilder sb = new StringBuilder();
//
//        for(String word : words){
//            sb.append(search(word)).append(" ");
//        }
//
//        sb.deleteCharAt(sb.length() - 1);
//
//        return sb.toString();
//    }
//
//    private void add(String word){
//        TrieNode node = root;
//        for(int i = 0; i < word.length(); i++){
//            char c = word.charAt(i);
//            if(!node.contains(c)){
//                node.put(c, new TrieNode());
//            }
//            node = node.get(c);
//        }
//        node.setHasWord();
//    }
//
//    private String search(String word){
//        TrieNode node = root;
//        for(int i = 0; i < word.length(); i++){
//            char c = word.charAt(i);
//            if(node.contains(c)){
//                if(node.get(c).isHasWord()){
//                    return word.substring(0, i + 1);
//                }
//                node = node.get(c);
//            } else {
//                return word;
//            }
//        }
//        return word;
//    }
//
//
//    class TrieNode {
//        int size = 26;
//        TrieNode[] links;
//        boolean hasWord;
//
//        public TrieNode(){
//            links = new TrieNode[size];
//        }
//
//        public boolean contains(char c){
//            return links[c - 'a'] != null;
//        }
//
//        public TrieNode get(char c){
//            return links[c - 'a'];
//        }
//
//        public void put(char c, TrieNode node){
//            links[c - 'a'] = node;
//        }
//
//        public void setHasWord(){
//            hasWord = true;
//        }
//
//        public boolean isHasWord(){
//            return hasWord;
//        }
//    }


    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode vocab = new TrieNode();
        for(String word: dictionary){
            add(vocab, word);
        }

        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String word: words){
            sb.append(getWord(word, vocab)).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public void add(TrieNode node, String s){
        TrieNode cur = node;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!cur.contains(c)){
                cur.put(c, new TrieNode());
            }
            cur = cur.get(c);
        }
        cur.setHasEnd();
    }

    public String getWord(String s, TrieNode root){
        TrieNode cur = root;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(cur.contains(c)){
                sb.append(c);
                if(cur.get(c).isHasEnd()){
                    return sb.toString();
                }
                cur = cur.get(c);
            } else{
                return s;
            }
        }
        return s;
    }


    class TrieNode{
        boolean hasEnd;
        TrieNode[] voc;

        public TrieNode(){
            voc = new TrieNode[26];
            hasEnd = false;
        }

        public boolean isHasEnd(){
            return hasEnd;
        }

        public void setHasEnd(){
            hasEnd = true;
        }

        public boolean contains(char c){
            return voc[c - 'a'] != null;
        }

        public TrieNode get(char c){
            return voc[c - 'a'];
        }

        public void put(char c, TrieNode node){
            voc[c - 'a'] = node;
        }
    }
}
