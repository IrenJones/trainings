package leetcode.medium;

public class CoinChange {

    public static void main(String[] args) {
        new CoinChange().coinChangeAgain(new int[] {2}, 3);
        new CoinChange().coinChangeAgain(new int[] {1, 2, 5}, 11);
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        return helper(coins, amount, new int[amount]);
    }

    // dp[] = array that contains amount of coins that is needed for sum i,
    // where sum starts from 1(index = 0) to amount(index = amount -1)
    public static int helper(int[] coins, int amount, int[] dp) {
        if (amount < 0) {
            return -1;
        }
        else if (amount == 0) {
            return 0;
        }
        else if (dp[amount - 1] != 0) {
            return dp[amount - 1];
        }

        int min = Integer.MAX_VALUE;

        for (int c : coins) {
            int result = helper(coins, amount - c, dp);

            if (result >= 0 && result < min) {
                min = 1 + result;
            }
        }

        dp[amount - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return dp[amount - 1];
    }

    public int coinChangeAgain(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        Integer[] dp = new Integer[amount + 1];
        dp[0] = 0;

        for (int cur = 1; cur <= amount; cur++) {
            int minValue = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin == cur) {
                    minValue = 1;
                    break;
                }
                else {
                    if (cur - coin > 0 && dp[cur - coin] != null) {
                        minValue = Math.min(minValue, dp[cur - coin] + 1);
                    }
                }
            }
            dp[cur] = minValue != Integer.MAX_VALUE ? minValue : null;
        }

        return dp[amount] != null ? dp[amount] : -1;
    }
}
