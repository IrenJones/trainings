package leetcode.easy;

public class DivisorGame {

    public boolean divisorGame(int n) {

        // default - all = false
        boolean[] dp = new boolean[n + 1];

        for(int i = 2; i < n + 1; i++) {
            for(int j = 1; j < i; j++) {
                if(i % j == 0 && !dp[i - j]){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
