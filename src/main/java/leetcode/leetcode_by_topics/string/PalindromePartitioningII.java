package leetcode.leetcode_by_topics.string;

public class PalindromePartitioningII {
    public int minCut(String s) {
        if(s.length() < 2){
            return 0;
        }

        int n = s.length();
        int[] cuts = new int[n];

        boolean [][] dp = new boolean[n][n];

        for(int i = 0; i < n; i++){
            int min = i;
            for(int start = 0; start <= i; start++){
                if(s.charAt(start) == s.charAt(i) && (start >= i-1 || dp[start + 1][i - 1] == true)){
                    dp[start][i] = true;
                    min = start > 0 ? Math.min(min, cuts[start - 1] + 1): 0;
                }
            }
            cuts[i] = min;
        }

        return cuts[n -1];
    }
}
