package leetcode.leetcode_by_topics.string;

public class NumberOfMatchingSubsequences {

    public static void main(String[] args) {
        NumberOfMatchingSubsequences s = new NumberOfMatchingSubsequences();
        s.numMatchingSubseq("dsahjpjauf", new String[]{"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"});
    }


    // TLE
    boolean[] fitted;

    public int numMatchingSubseq(String s, String[] words) {
        int n = s.length();
        fitted = new boolean[words.length];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < words.length; j++){
                if(!fitted[j] && s.charAt(i) == words[j].charAt(0) && i + words[j].length() < n){
                    int c = 1;
                    int k = 1;
                    int kk = 1;
                    while(k < words[j].length() && i + kk < n){
                        if(words[j].charAt(k) == s.charAt(i + kk)){
                            c++;
                            k++;
                            kk++;
                        } else{
                            kk++;
                        }
                    }
                    if(c == words[j].length()){
                        fitted[j] = true;
                    }
                }
            }
        }

        int count = 0;
        for(int i = 0; i < words.length; i++){
            if(fitted[i]){
                count++;
            }
        }

        return count;
    }

    public int numMatchingSubseqBetter(String s, String[] words) {
        fitted = new boolean[words.length];

        int count = 0;
        for(int i = 0; i < words.length; i++){
            if(!fitted[i] && check(s, words[i], i)){
                count++;
            }
        }

        return count;
    }

    private boolean check(String s, String word, int i) {
        int prev  = 0;
        for (char c : word.toCharArray()) {

            int index = s.indexOf(c, prev);
            if (index == -1) {
                return false;
            }
            prev = index + 1;
        }

        fitted[i] = true;

        return true;
    }
}
