package leetcode.leetcode_by_topics.string;

public class InterleavingString {

    public static void main(String[] args) {
        InterleavingString s = new InterleavingString();
        s.isInterleaveBetter("a", "b", "ab");
    }

    boolean res = false;

    // TLE
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }

        helper(0, 0, 0, s1, s2, s3);

        return res;
    }

    public void helper(int i , int j, int k, String s1, String s2, String s3){
        if(res){
            return;
        }

        if(k == s3.length()){
            res = true;
            return;
        }

        if(i < s1.length() && s1.charAt(i) == s3.charAt(k)){
            helper(i + 1, j, k + 1, s1, s2, s3);
        }

        if(j < s2.length() && s2.charAt(j) == s3.charAt(k)){
            helper(i, j + 1, k + 1, s1, s2, s3);
        }
    }

    public boolean isInterleaveBetter(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();

        if (n + m != s3.length()) {
            return false;
        }
        else if (n == 0 && m > 0) {
            return s3.equals(s2);
        }
        else if (m == 0 && n > 0) {
            return s3.equals(s1);
        }
        else if (n == 0 && m == 0) {
            return s3.length() == 0;
        }

        boolean[][] path = new boolean[n + 1][m + 1];
        path[0][0] = true;

        for (int i = 1; i <= n; i++) {
            if (path[i - 1][0] == true && s1.charAt(i - 1) == s3.charAt(i - 1)) {
                path[i][0] = true;
            }
        }

        for (int j = 1; j <= m; j++) {
            if (path[0][j - 1] == true && s2.charAt(j - 1) == s3.charAt(j - 1)) {
                path[0][j] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (path[i - 1][j] == true && s1.charAt(i - 1) == s3.charAt(i + j - 1)
                    || path[i][j - 1] == true && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    path[i][j] = true;
                }
            }
        }

        return path[n][m];
    }
}
