package leetcode.easy;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7, 1, 5, 3, 6, 4}) == 5);
    }

    public static int maxProfit(int[] prices) {
        int maxDiff = 0;
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minValue) {
                minValue = prices[i];
            }
            else if (prices[i] - minValue > maxDiff) {
                maxDiff = prices[i] - minValue;
            }
        }

        return maxDiff;
    }

    public int maxProfitAgain(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - min);
            min = Math.min(prices[i], min);
        }

        return profit;
    }
}
